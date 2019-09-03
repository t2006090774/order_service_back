package com.order.controller;

import com.order.bean.Commodity;
import com.order.bean.JSONResult;
import com.order.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: order-service
 * @description:
 * @author: jax
 * * @create: 2019-08-30 16:51
 **/
@RestController
@RequestMapping("back_api/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    /**
     * 获取菜品列表
     * @param commodity
     * @return
     */
    @GetMapping("/commodityList")  //
    public JSONResult commodityList(@RequestBody Commodity commodity){

        if(StringUtils.isEmpty(commodity.getShopId())){
            return JSONResult.errorMsg("店铺id不可为空");
        }
        return JSONResult.succeed(commodityService.getCommodityList(commodity));
    }

    @PostMapping("/save")
    public JSONResult saveCommodity(@RequestBody Commodity commodity){
        if(StringUtils.isEmpty(commodity.getCommodityType()))
            return JSONResult.errorMsg("菜品分类不可为空");
        if(StringUtils.isEmpty(commodity.getCommodityName()))
            return JSONResult.errorMsg("菜品名称不可为空");
        if(StringUtils.isEmpty(commodity.getCommodityPrice()))
            return JSONResult.errorMsg("菜品价格不可为空");
        if(StringUtils.isEmpty(commodity.getShopId()))
            return JSONResult.errorMsg("店铺id不可为空");
        return JSONResult.succeed(commodityService.save(commodity));
    }

    /**
     * 获取菜品分类下拉
     * @param shopId
     * @return
     */
    @PostMapping("/getCommodityType/{shopId}")
    public JSONResult getCommodityType(@PathVariable("shopId")Integer shopId){
        if(StringUtils.isEmpty(shopId))
            return JSONResult.errorMsg("店铺id不可为空");
        return JSONResult.succeed(commodityService.getCommodityType(shopId));
    }

}
