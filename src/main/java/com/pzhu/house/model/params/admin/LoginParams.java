package com.pzhu.house.model.params.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginParams implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 16, message = "用户名长度为5-16个字符")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码不能为空")
    @Length(min = 4, max = 4, message = "验证码错误")
    private String code;
    private String uuid;
    private Boolean rememberMe = false;

}
