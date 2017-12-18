package com.diancan.respositorys;

import com.diancan.domain.resto.Restaurant;
import com.diancan.domain.resto.metadata.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    // 通过餐厅所在省份获得
    List<Restaurant> findRestaurantsByAddress_Province(Province province);
    List<Restaurant> findRestaurantsByAddress_City(City city);
    List<Restaurant> findRestaurantsByAddress_County(County county);
    List<Restaurant> findRestaurantsByAddress_Town(Town town);
    List<Restaurant> findRestaurantsByAddress_Street(Street street);
    List<Restaurant> findRestaurantsByAddress_Desc(String desc);
    List<Restaurant> findRestaurantsByAddress_Latitude(String latitude);
    //通过评分模糊匹配,大于等于给定的评分
    List<Restaurant> findRestaurantsByRatingGreaterThanEqual(Integer rating);

}
