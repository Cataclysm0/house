package com.pzhu.house.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.model.entity.admin.SysMenu;
import com.pzhu.house.mapper.admin.SysMenuMapper;
import com.pzhu.house.service.admin.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-17
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> getMenus() {
        return menuMapper.selectList(new QueryWrapper<SysMenu>().orderByAsc("order_num"));
    }
}
