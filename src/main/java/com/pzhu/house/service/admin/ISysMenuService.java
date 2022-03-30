package com.pzhu.house.service.admin;

import com.pzhu.house.entity.admin.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-17
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getMenus();
}
