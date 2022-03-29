package com.pzhu.house.model.entity.city;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 中国城市表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "China对象", description = "中国城市表")
public class China extends Model<China> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地区ID")
    private Long id;

    @ApiModelProperty("父级地区ID")
    private Long pid;

    @ApiModelProperty("名称")
    private String name;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
