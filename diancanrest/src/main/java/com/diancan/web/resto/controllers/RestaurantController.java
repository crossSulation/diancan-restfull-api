package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.Restaurant;
import com.diancan.service.resto.RestarantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restoinfo")
public class RestaurantController {

    @Autowired
    RestarantServiceImpl restarantService;

    /**
     *
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,path = "/{id}")
    public Restaurant getRestaurantById(@PathVariable long id) {

        return restarantService.findRestaurantById(id);
    }

    /**
     * @desc 返回所有的餐馆信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return  restarantService.getAllRestaurants();
    }

    /**
     * @desc 添加一个新的餐馆
     * @param restaurant
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Restaurant addNewRestoBasicInfo(
            @RequestBody() Restaurant restaurant
    ) {
        return  restarantService.addNewRestaurant(restaurant);
    }

    /**
     *
     * @param address
     * @return
     */
    @GetMapping(value = "/{address}",params = "address")
    public  List<Restaurant> getRestaurantsByGivenAddress(@PathVariable String address) {
        return  restarantService.findRestaurantByGivenAdress(address);
    }

    @GetMapping(value = "/{rating}",params = "rating")
    public  List<Restaurant> getRestaurantByGivenRating(@PathVariable Integer rating) {
         return  restarantService.findRestaurantByGivenRating(rating);
    }
    /**
     * @desc 删除
     * @param id
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delOneRestaurantById(@PathVariable long id) {
         restarantService.delRestaurantById(id);
    }
}
