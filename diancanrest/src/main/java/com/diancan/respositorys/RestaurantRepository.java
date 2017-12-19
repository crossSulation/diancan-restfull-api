package com.diancan.respositorys;

import com.diancan.domain.resto.Restaurant;
import com.diancan.domain.resto.metadata.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    // 通过餐厅所在省份获得
    List<Restaurant> findRestaurantsByAddress_Province(Province province);
    //通过餐厅所在城市获取
    List<Restaurant> findRestaurantsByAddress_City(City city);
    //通过餐厅所在县城获取
    List<Restaurant> findRestaurantsByAddress_County(County county);
    //通过餐厅所在城镇获取
    List<Restaurant> findRestaurantsByAddress_Town(Town town);
    //通过餐厅所在
    List<Restaurant> findRestaurantsByAddress_Street(Street street);
    //通过餐厅地址描述
    List<Restaurant> findRestaurantsByAddress_Desc(String desc);
    //通过经度
    List<Restaurant> findRestaurantsByAddress_Latitude(String latitude);
    //通过纬度
    List<Restaurant> findRestaurantsByAddress_Longitude(String longitude);
    //通过评分模糊匹配,大于等于给定的评分
    List<Restaurant> findRestaurantsByRatingGreaterThanEqual(Integer rating);

}
