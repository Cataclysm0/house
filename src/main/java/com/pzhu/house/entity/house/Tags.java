package com.pzhu.house.entity.house;

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
 * 标签表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-30
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Tags对象", description = "标签表")
public class Tags extends Model<Tags> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("房源ID")
    private Long houseId;

    @ApiModelProperty("标签内容")
    private String content;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
