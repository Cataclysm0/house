package com.pzhu.house.service.user.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.common.constant.Constants;
import com.pzhu.house.common.constant.UserConstants;
import com.pzhu.house.exception.BaseException;
import com.pzhu.house.exception.captcha.CaptchaExpireException;
import com.pzhu.house.exception.captcha.CaptchaIncorrectException;
import com.pzhu.house.model.entity.system.SysUser;
import com.pzhu.house.service.system.ISysUserRoleService;
import com.pzhu.house.service.system.ISysUserService;
import com.pzhu.house.service.user.IUserLoginService;
import com.pzhu.house.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysUserRoleService userRoleService;

    @Autowired
    private RedisCache redisCache;

    @Override
    public String login(String username, String password) {
        SysUser user = userService.getOne(new QueryWrapper<SysUser>()
                .select("id", "password")
                .eq("username", username).or()
                .eq("email", username).or()
                .eq("phonenumber", username));
        if (user == null || !SecureUtil.sha256(password).equals(user.getPassword())) {
            throw new BaseException(402, "用户名或密码错误");
        }
        StpUtil.login(user.getId(), true);
        return StpUtil.getTokenValue();
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public String register(String username, String password, String rePassword, String phonenumber, String email, String code, String uuid) {
        validateCaptcha(code, uuid);
        String msg = null;
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUsernameUnique(username))) {
            msg = "用户名已存在";
        } else if (!password.equals(rePassword)) {
            msg = "两次密码不一致";
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(phonenumber))) {
            msg = "手机号已存在";
        } else if (!ObjectUtils.isEmpty(email) && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(email))) {
            msg = "邮箱已存在";
        } else {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(username);
            sysUser.setNickname(username);
            sysUser.setPhonenumber(phonenumber);
            sysUser.setEmail(email);
            sysUser.setPassword(SecureUtil.sha256(password));
            sysUser.setAvatar("http://127.0.0.1:9000/house/images/profile.png");
            sysUser.setStatus(0);
            sysUser.setCreatedBy("self");
            sysUser.setCreatedTime(LocalDateTime.now(Clock.system(ZoneId.systemDefault())));
            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag) {
                msg = "注册失败,请联系系统管理人员";
            }
            int flag = userRoleService.addUserRole(sysUser, 2L);
        }
        return msg;
    }

    /**
     * 校验验证码
     *
     * @param code 验证码
     * @param uuid 唯一标识
     */
    public void validateCaptcha(String code, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + StrUtil.emptyToDefault(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaIncorrectException();
        }
    }

}
