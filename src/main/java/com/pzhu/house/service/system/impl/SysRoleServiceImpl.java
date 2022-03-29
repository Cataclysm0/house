package com.pzhu.house.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.model.entity.system.SysRole;
import com.pzhu.house.mapper.system.SysRoleMapper;
import com.pzhu.house.service.system.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzhu.house.service.system.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private ISysUserRoleService userRoleService;

    @Override
    public String getRole(Long loginId) {
        Long roleId = userRoleService.getRoleId(loginId);
        SysRole sysRole = roleMapper.selectOne(new QueryWrapper<SysRole>().select("id").select("role_key").eq("id", roleId));
        System.out.println(sysRole.getRoleKey());
        return sysRole.getRoleKey();
    }
}
