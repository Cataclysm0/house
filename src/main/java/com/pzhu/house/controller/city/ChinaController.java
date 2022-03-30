package com.pzhu.house.controller.city;

import com.pzhu.house.entity.city.China;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.city.IChinaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 中国城市表 前端控制器
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Api(tags = "城市控制器")
@RestController
@RequestMapping("/china")
public class ChinaController {

    @Autowired
    private IChinaService chinaService;

    @ApiOperation("获取省份接口")
    @GetMapping("/getProvinces")
    public AjaxResult getProvinces() {
        AjaxResult result = AjaxResult.success();
        List<China> provinceList = chinaService.getAllProvinceList();
        result.put("provinces", provinceList);
        return result;
    }

    @ApiOperation("根据省份获取城市接口")
    @GetMapping("/getCities/provinceId/{provinceId}")
    public AjaxResult getCitiesByProvinceId(@PathVariable Long provinceId) {
        AjaxResult result = AjaxResult.success();
        List<China> provinceList = chinaService.getCityListByProvinceId(provinceId);
        result.put("provinces", provinceList);
        return result;
    }

    @ApiOperation("根据大区获取城市接口")
    @GetMapping("/getCities/regionId/{regionId}")
    public AjaxResult getCitiesByRegionId(@PathVariable Long regionId) {
        AjaxResult result = AjaxResult.success();
        List<China> provinceList = chinaService.getCityListByRegionId(regionId);
        result.put("provinces", provinceList);
        return result;
    }

    @ApiOperation("根据城市获取县区接口")
    @GetMapping("/getDistricts/{cityId}")
    public AjaxResult getDistrictsByCityId(@PathVariable Long cityId) {
        AjaxResult result = AjaxResult.success();
        List<China> districtList = chinaService.getDistrictsByCityId(cityId);
        result.put("districts", districtList);
        return result;
    }

}
