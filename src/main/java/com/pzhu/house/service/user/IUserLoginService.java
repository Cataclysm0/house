package com.pzhu.house.service.user;

public interface IUserLoginService {
    String login(String username, String password);

    String register(String username, String password, String rePassword, String phonenumber, String email, String code, String uuid);

}
