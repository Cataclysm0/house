package com.pzhu.house.service.admin;

public interface IAdminLoginService {

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return token
     */
    String login(String username, String password, String code, String uuid, Boolean rememberMe);

}
