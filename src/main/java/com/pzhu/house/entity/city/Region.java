package com.pzhu.house.entity.city;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 大区表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Region对象", description = "大区表")
public class Region extends Model<Region> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("大区ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("大区名称")
    private String name;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
