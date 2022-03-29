package com.pzhu.house.model.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单表")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    private Long id;

    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("路径")
    private String path;

    private String name;

    @ApiModelProperty("菜单标签")
    private String label;

    @ApiModelProperty("菜单图标")
    private String icon;

    private String url;

    @ApiModelProperty("顺序")
    private Integer orderNum;

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
        return null;
    }

}
