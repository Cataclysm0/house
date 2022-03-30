package com.pzhu.house.model.lease;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("SummaryLeaseInfo")
public class BriefLeaseInfo implements Serializable {

    @ApiModelProperty("租约ID")
    private Long id;

    @ApiModelProperty("封面")
    private String cover;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("区（县）名称")
    private String district;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("房租")
    private BigDecimal rent;

    @ApiModelProperty("租约状态 0-租期中 1-已退房")
    private Short status;

}
