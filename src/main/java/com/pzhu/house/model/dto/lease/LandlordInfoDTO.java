package com.pzhu.house.model.dto.lease;

import com.pzhu.house.model.dto.base.OutputConverter;
import com.pzhu.house.model.entity.system.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("LandlordInfoDTO")
@Data
public class LandlordInfoDTO implements OutputConverter<LandlordInfoDTO, SysUser>, Serializable {

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("手机号")
    private String phonenumber;

}
