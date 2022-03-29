package com.pzhu.house.model.entity.city;

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
 * 
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("region_city")
@ApiModel(value = "RegionCity对象", description = "")
public class RegionCity extends Model<RegionCity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("大区ID")
    private Long regionId;

    @ApiModelProperty("城市ID")
    private Long cityId;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
