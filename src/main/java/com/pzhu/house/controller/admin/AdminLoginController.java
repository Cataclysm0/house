package com.pzhu.house.controller.admin;

import cn.dev33.satoken.stp.StpUtil;
import com.pzhu.house.model.dto.admin.UserDTO;
import com.pzhu.house.model.entity.admin.SysMenu;
import com.pzhu.house.model.entity.system.SysUser;
import com.pzhu.house.model.params.admin.LoginParams;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.admin.IAdminLoginService;
import com.pzhu.house.service.admin.ISysMenuService;
import com.pzhu.house.service.system.ISysUserService;
import com.pzhu.house.utils.ip.AddressUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "登录控制器")
@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private IAdminLoginService loginService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysMenuService menuService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody @Validated LoginParams loginParams) {
        AjaxResult result = AjaxResult.success();
        String token = loginService.login(loginParams.getUsername(), loginParams.getPassword(), loginParams.getCode(), loginParams.getUuid(), loginParams.getRememberMe());
        result.put("satoken", token);
        return result;
    }

    @ApiOperation("获取用户信息接口")
    @GetMapping("/getInfo")
    public AjaxResult getInfo() {
        SysUser user = userService.getUserById(Long.parseLong((String) StpUtil.getLoginId()));
        // 角色集合
        List<String> roles = StpUtil.getRoleList();
        AjaxResult ajax = AjaxResult.success();
        UserDTO userDTO = new UserDTO().convertFrom(user);
        ajax.put("user", userDTO);
        ajax.put("roles", roles);
        ajax.put("address", AddressUtils.getRealAddressByIP(user.getLastLoginIp()));
        return ajax;
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public AjaxResult logout(String token) {

        StpUtil.logoutByTokenValue(token);
        return AjaxResult.success();
    }

    @ApiOperation("获取路由信息")
    @GetMapping("/getRouters")
    public AjaxResult getRouters() {
        List<SysMenu> menus = menuService.getMenus();
        return AjaxResult.success(menus);
    }

}
