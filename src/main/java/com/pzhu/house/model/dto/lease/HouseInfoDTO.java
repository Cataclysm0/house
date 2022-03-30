package com.pzhu.house.model.dto.lease;

import com.pzhu.house.model.dto.base.OutputConverter;
import com.pzhu.house.entity.house.HouseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("HouseInfoDTO")
public class HouseInfoDTO implements OutputConverter<HouseInfoDTO, HouseInfo>, Serializable {

    @ApiModelProperty("房源ID")
    private Long id;

    @ApiModelProperty("房东ID")
    private Long landlordId;

    @ApiModelProperty("房源标题")
    private String title;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("房屋押金")
    private BigDecimal deposit;

    @ApiModelProperty("省份名称")
    private String province;

    @ApiModelProperty("城市名称")
    private String city;

    @ApiModelProperty("区（县）名称")
    private String district;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("小区名称")
    private String compoundName;

    @ApiModelProperty("房内设施")
    private String facilities;

    @ApiModelProperty("房源描述")
    private String describe;

    @ApiModelProperty("出租类型 0-月租 1-季租 2-年租")
    private Integer rentalType;

    @ApiModelProperty("户型（三室一厅）")
    private String type;

    @ApiModelProperty("房间面积")
    private Double area;

    @ApiModelProperty("房源状态 0-发布 1-已租 2-已退房 3-封禁")
    private Integer status;

    @ApiModelProperty("联系电话")
    private String contactNumber;

    @ApiModelProperty("联系人姓名")
    private String contactName;

}
