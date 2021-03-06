package com.pzhu.house.model.dto.user;

import com.pzhu.house.model.dto.base.OutputConverter;
import com.pzhu.house.entity.system.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("UserDTO")
public class UserDTO implements OutputConverter<UserDTO, SysUser>, Serializable {

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

}
