package com.pzhu.house.entity.house;

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
 * 房源图片表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("house_picture")
@ApiModel(value = "HousePicture对象", description = "房源图片表")
public class HousePicture extends Model<HousePicture> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图片ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("房源ID")
    private Long houseId;

    @ApiModelProperty("图片顺序")
    private Integer orderNum;

    @ApiModelProperty("图片地址")
    private String imgUrl;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
