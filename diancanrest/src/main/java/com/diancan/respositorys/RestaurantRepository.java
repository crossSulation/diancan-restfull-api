package com.diancan.respositorys;

import com.diancan.domain.resto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    // 通过餐厅地址模糊查询
    List<Restaurant> findRestaurantsByRestoAddressContains(String address);
    //通过评分模糊匹配,大于等于给定的评分
    List<Restaurant> findRestaurantsByRatingGreaterThanEqual(Integer rating);

}
