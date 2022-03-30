package com.pzhu.house.model.dto.admin;

import com.pzhu.house.model.dto.base.OutputConverter;
import com.pzhu.house.entity.system.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("UserDTO")
public class UserDTO implements OutputConverter<UserDTO, SysUser>, Serializable {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("性别 0 - 男, 1 - 女, 2 - 未知")
    private Integer gender;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("手机号")
    private String phonenumber;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime lastLoginDate;

    @ApiModelProperty("最后登录Ip")
    private String lastLoginIp;

}
