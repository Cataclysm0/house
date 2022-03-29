package com.pzhu.house.model.entity.lease;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 投诉信息表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("complaint_info")
@ApiModel(value = "ComplaintInfo对象", description = "投诉信息表")
public class ComplaintInfo extends Model<ComplaintInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("房源ID")
    private Long houseId;

    @ApiModelProperty("投诉内容")
    private String content;

    @ApiModelProperty("投诉状态 0-待处理 1-申诉中 2-已处理")
    private String status;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
