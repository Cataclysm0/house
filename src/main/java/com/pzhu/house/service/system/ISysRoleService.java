package com.pzhu.house.service.system;

import com.pzhu.house.entity.system.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 获取用户角色
     * @param loginId
     * @return
     */
    String getRole(Long loginId);
}
