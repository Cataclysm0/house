package com.pzhu.house.mapper.system;

import com.pzhu.house.entity.system.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    int updateUser(SysUser user);

    int checkUsernameUnique(String userName);

    SysUser checkPhoneUnique(String phonenumber);

    SysUser checkEmailUnique(String email);

    int insertUser(SysUser user);
}
