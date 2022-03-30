package com.pzhu.house.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.common.constant.UserConstants;
import com.pzhu.house.entity.system.SysUser;
import com.pzhu.house.mapper.system.SysUserMapper;
import com.pzhu.house.service.system.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser getUserById(Long loginId) {
        SysUser user = userMapper.selectById(loginId);
        user.setPassword(null);
        return user;
    }

    @Override
    public int updateUserProfile(SysUser user) {
        return userMapper.updateById(user);
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param username 用户名
     * @return 结果
     */
    @Override
    public String checkUsernameUnique(String username) {
        int count = userMapper.checkUsernameUnique(username);
        if (count > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号
     * @return
     */
    @Override
    public String checkPhoneUnique(String phonenumber) {
        SysUser info = userMapper.checkPhoneUnique(phonenumber);
        if (!ObjectUtils.isEmpty(info)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param email 邮箱
     * @return
     */
    @Override
    public String checkEmailUnique(String email) {
        SysUser info = userMapper.checkEmailUnique(email);
        if (!ObjectUtils.isEmpty(info)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 注册用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean registerUser(SysUser user)
    {
        return userMapper.insertUser(user) > 0;
    }

    /**
     * 房东信息
     * @param landlordId
     * @return
     */
    @Override
    public SysUser getLandlordInfo(Long landlordId) {
        return userMapper.selectOne(new QueryWrapper<SysUser>().select("id", "real_name", "phonenumber").eq("id", landlordId));
    }
}
