package com.pzhu.house.model.house;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("BriefHouseInfo")
public class BriefHouseInfo implements Serializable {

    @ApiModelProperty("房源ID")
    private Long id;

    @ApiModelProperty("房源标题")
    private String title;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("区（县）名称")
    private String district;

    @ApiModelProperty("小区名称")
    private String compoundName;

    @ApiModelProperty("房间面积")
    private Double area;

    @ApiModelProperty("房源封面")
    private String cover;

    private List<TagModel> tags;

}
