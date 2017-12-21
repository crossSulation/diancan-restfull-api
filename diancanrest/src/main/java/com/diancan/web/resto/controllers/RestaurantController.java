package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.Restaurant;
import com.diancan.domain.resto.metadata.Province;
import com.diancan.service.resto.RestarantServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
@Api(value="Restaurant")
public class RestaurantController {

    @Autowired
    RestarantServiceImpl restarantService;

    /**
     *
     * @param id 主键id
     * @return
     */
    @ApiOperation(value = "通过id获取指定餐馆",notes = "")
    @ApiImplicitParam(value = "id",name="id",dataType = "Long", paramType = "path",defaultValue = "0")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,path = "/{id}")
    public Restaurant getRestaurantById(@PathVariable long id) {

        return restarantService.findRestaurantById(id);
    }

    /**
     * @desc 返回所有的餐馆信息
     * @return
     */
    @ApiOperation(value = "获取所有的餐馆")
    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return  restarantService.getAllRestaurants();
    }

    /**
     * @desc 添加一个新的餐馆
     * @param restaurant
     * @return
     */
    @ApiOperation(value = "添加一个餐馆",httpMethod = "POST")
    @ApiImplicitParam(value = "restaurant",name="restaurant",dataType = "Object", paramType = "Restaurant",required = true)
    @RequestMapping(method = RequestMethod.POST)
    public Restaurant addNewRestaurant(
            @RequestBody() Restaurant restaurant
    ) {
        return  restarantService.addNewRestaurant(restaurant);
    }

    /**
     *
     * @param provinceId
     * @return
     */
    @ApiOperation(value = "根据省份获取餐馆")
    @ApiImplicitParam(value = "provinceId",name = "provinceId",dataType = "provinceId",paramType = "path",required = true)
    @GetMapping(path = "/province/{provinceId}")
    public  List<Restaurant> getRestaurantsByGivenAddressProvince(@PathVariable Long provinceId) {
        return  restarantService.findRestaurantByGivenAdressProvince(provinceId);
    }

    @ApiOperation(value = "根据评分获取餐馆",notes = "")
    @ApiImplicitParam(value="rating",name = "rating",dataType = "Integer",paramType = "path",required = true)
    @GetMapping(path = "/rating/{rating}")
    public  List<Restaurant> getRestaurantByGivenRating(@PathVariable Integer rating) {
         return  restarantService.findRestaurantByGivenRating(rating);
    }
    /**
     * @desc 删除
     * @param id
     */
    @ApiOperation(value ="根据给定id删除餐馆",notes = "")
    @ApiImplicitParam(value = "id",name = "id",dataType = "Integer",paramType = "path",required = true)
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delOneRestaurantById(@PathVariable long id) {
         restarantService.delRestaurantById(id);
    }
}
