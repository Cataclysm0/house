package com.pzhu.house.service.system;

import com.pzhu.house.entity.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-15
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 根据ID获取用户信息
     * @param loginId
     * @return
     */
    SysUser getUserById(Long loginId);

    /**
     * 修改用户基本信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int updateUserProfile(SysUser user);

    /**
     * 校验用户名称是否唯一
     *
     * @param username 用户名
     * @return 结果
     */
    public String checkUsernameUnique(String username);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号
     * @return 结果
     */
    public String checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @param email 邮箱
     * @return 结果
     */
    public String checkEmailUnique(String email);

    /**
     * 注册用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public boolean registerUser(SysUser user);

    /**
     * 房东信息
     * @param landlordId
     * @return
     */
    SysUser getLandlordInfo(Long landlordId);
}
