package com.pzhu.house.entity.house;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房源信息表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("house_info")
@ApiModel(value = "HouseInfo对象", description = "房源信息表")
public class HouseInfo extends Model<HouseInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("房源ID")
    @TableId(value = "id", type = IdType.AUTO)
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
    private String houseDescribe;

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

    @ApiModelProperty("乐观锁")
    @Version
    private Long revision;

    @ApiModelProperty("创建人")
    private String createdBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新人")
    private String updatedBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
