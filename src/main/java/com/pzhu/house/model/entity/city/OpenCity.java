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
 * 开通城市表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("open_city")
@ApiModel(value = "OpenCity对象", description = "开通城市表")
public class OpenCity extends Model<OpenCity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("开通城市")
    private Long cityId;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
