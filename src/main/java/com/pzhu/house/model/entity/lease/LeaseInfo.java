package com.pzhu.house.model.entity.lease;

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
 * 租约信息表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("lease_info")
@ApiModel(value = "LeaseInfo对象", description = "租约信息表")
public class LeaseInfo extends Model<LeaseInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("租约ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租客ID")
    private Long tenantId;

    @ApiModelProperty("房东ID")
    private Long landlordId;

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
