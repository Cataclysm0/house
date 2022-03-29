package com.pzhu.house.controller.city;

import com.pzhu.house.model.entity.city.China;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.city.IChinaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequestMapping("/china")
public class ChinaController {

    @Autowired
    private IChinaService chinaService;

    @ApiOperation("获取省份接口")
    @GetMapping("/getProvinces")
    public AjaxResult getProvinces() {
        AjaxResult result = AjaxResult.success();
        List<China> provinceList = chinaService.getProvinceList();
        result.put("provinces", provinceList);
        return result;
    }

}
