package com.pzhu.house.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import com.pzhu.house.model.dto.user.UserDTO;
import com.pzhu.house.model.entity.system.SysUser;
import com.pzhu.house.model.params.user.LoginParams;
import com.pzhu.house.model.params.user.RegisterParams;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.user.IUserLoginService;
import com.pzhu.house.service.system.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private IUserLoginService loginService;

    @Autowired
    private ISysUserService userService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody @Validated LoginParams loginParams) {
        AjaxResult result = AjaxResult.success();
        String token = loginService.login(loginParams.getUsername(), loginParams.getPassword());
        result.put("satoken", token);
        return result;
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Validated RegisterParams registerParams) {
        String msg = loginService.register(registerParams.getUsername(), registerParams.getPassword(), registerParams.getRePassword(), registerParams.getPhonenumber(), registerParams.getEmail(), registerParams.getCode(), registerParams.getUuid());
        return ObjectUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
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
        return ajax;
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public AjaxResult logout(String token) {
        StpUtil.logoutByTokenValue(token);
        return AjaxResult.success();
    }

}
