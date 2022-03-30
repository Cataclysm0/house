package com.pzhu.house.controller.city;

import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.city.IRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 大区表 前端控制器
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Api(tags = "大区控制器")
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private IRegionService regionService;

    @ApiOperation("获取大区")
    @GetMapping("/getRegions")
    public AjaxResult getRegions() {
        AjaxResult result = AjaxResult.success();
        result.put("regions", regionService.getAllRegions());
        return result;
    }


}
