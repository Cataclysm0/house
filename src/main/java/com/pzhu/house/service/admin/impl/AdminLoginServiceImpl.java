package com.pzhu.house.service.admin.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.common.constant.Constants;
import com.pzhu.house.exception.BaseException;
import com.pzhu.house.exception.captcha.CaptchaIncorrectException;
import com.pzhu.house.exception.captcha.CaptchaExpireException;
import com.pzhu.house.model.entity.system.SysUser;
import com.pzhu.house.service.admin.IAdminLoginService;
import com.pzhu.house.service.system.ISysUserService;
import com.pzhu.house.utils.ServletUtils;
import com.pzhu.house.utils.ip.IpUtils;
import com.pzhu.house.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class AdminLoginServiceImpl implements IAdminLoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    @Override
    public String login(String username, String password, String code, String uuid, Boolean rememberMe) {
        validateCaptcha(code, uuid);
        SysUser user = userService.getOne(new QueryWrapper<SysUser>()
                .select("id", "password")
                .eq("username", username).or()
                .eq("email", username).or()
                .eq("phonenumber", username));
        if (user == null || !user.getPassword().equals(SecureUtil.sha256(password))) {
            throw new BaseException(402, "用户名或密码错误");
        }
        StpUtil.login(user.getId(), rememberMe);
        recordLoginInfo(user.getId());
        return StpUtil.getTokenValue();
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setLastLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        sysUser.setLastLoginDate(LocalDateTime.now(Clock.system(ZoneId.systemDefault())));
        sysUser.setUpdatedTime(LocalDateTime.now(Clock.system(ZoneId.systemDefault())));
        userService.updateUserProfile(sysUser);
    }

    /**
     * 校验验证码
     *
     * @param code 验证码
     * @param uuid 唯一标识
     */
    public void validateCaptcha(String code, String uuid)
    {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + StrUtil.emptyToDefault(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaIncorrectException();
        }
    }

}
