package com.pzhu.house.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.entity.system.SysUser;
import com.pzhu.house.entity.system.SysUserRole;
import com.pzhu.house.mapper.system.SysUserRoleMapper;
import com.pzhu.house.service.system.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    public Long getRoleId(Long loginId) {
        SysUserRole userRole = userRoleMapper.selectOne(new QueryWrapper<SysUserRole>().eq("user_id", loginId));
        return userRole.getRoleId();
    }

    @Override
    public int addUserRole(SysUser sysUser, Long roleId) {
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(sysUser.getId());
        userRole.setRoleId(roleId);
        return userRoleMapper.insertUserRole(userRole);
    }
}
