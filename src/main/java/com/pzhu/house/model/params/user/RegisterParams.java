package com.pzhu.house.model.params.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterParams implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 16, message = "用户名长度为5-16个字符")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码长度为6-18个字符")
    private String password;
    @NotBlank(message = "请确认密码")
    private String rePassword;
    @NotBlank(message = "手机号不能为空")
    private String phonenumber;
    private String email;
    @NotBlank(message = "验证码不能为空")
    @Length(min = 4, max = 4, message = "验证码错误")
    private String code;
    private String uuid;

}
