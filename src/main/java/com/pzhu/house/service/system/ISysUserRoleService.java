package com.pzhu.house.service.system;

import com.pzhu.house.model.entity.system.SysUser;
import com.pzhu.house.model.entity.system.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户ID获取角色ID
     * @param loginId
     * @return
     */
    Long getRoleId(Long loginId);

    int addUserRole(SysUser sysUser, Long roleId);
}
