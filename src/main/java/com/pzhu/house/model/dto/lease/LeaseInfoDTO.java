package com.pzhu.house.model.dto.lease;

import com.pzhu.house.model.dto.base.OutputConverter;
import com.pzhu.house.model.entity.lease.LeaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "LeaseInfoDTO", description = "租约信息")
public class LeaseInfoDTO implements OutputConverter<LeaseInfoDTO, LeaseInfo>, Serializable {

    @ApiModelProperty("起始日期")
    private LocalDateTime startDate;

    @ApiModelProperty("终止日期")
    private LocalDateTime endDate;

    @ApiModelProperty("房租")
    private BigDecimal rent;

    @ApiModelProperty("房屋押金")
    private BigDecimal deposit;

    @ApiModelProperty("租客姓名")
    private String tenantName;

    @ApiModelProperty("租客性别")
    private String tenantGender;

    @ApiModelProperty("租客电话")
    private String tenantPhonenumber;

    @ApiModelProperty("备注")
    private String remarks;

}
