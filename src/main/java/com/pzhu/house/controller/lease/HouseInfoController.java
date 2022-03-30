package com.pzhu.house.controller.lease;

import com.pzhu.house.model.house.BriefHouseInfo;
import com.pzhu.house.model.params.mobile.IndexHoseListParams;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.house.IHouseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 房源信息表 前端控制器
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Api(tags = "房源信息控制器")
@RestController
@RequestMapping("/house-info")
public class HouseInfoController {

    @Autowired
    private IHouseInfoService houseInfoService;

    @ApiOperation("首页租房信息列表")
    @GetMapping("/get-index-house-info-list")
    public AjaxResult getIndexHouseInfoList(IndexHoseListParams params) {
        AjaxResult result = AjaxResult.success();
        List<BriefHouseInfo> list = houseInfoService.getIndexHouseInfoList(params);
        result.put("rentalLists", list);
        return result;
    }

}
