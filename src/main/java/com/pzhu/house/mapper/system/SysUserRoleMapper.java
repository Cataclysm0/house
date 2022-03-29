package com.pzhu.house.mapper.system;

import com.pzhu.house.model.entity.system.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    int insertUserRole(SysUserRole userRole);
}
