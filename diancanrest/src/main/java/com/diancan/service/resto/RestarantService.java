package com.diancan.service.resto;

import com.diancan.domain.resto.Restaurant;
import com.diancan.domain.resto.metadata.Province;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RestarantService {

    Restaurant findRestaurantById(long id);

    List<Restaurant> findRestaurantByGivenAdressProvince(Long provinceId);

    List<Restaurant> findRestaurantByGivenRating(Integer rating);

    void delRestaurantById(long id);

    Restaurant addNewRestaurant(Restaurant restaurant);

    List<Restaurant>  getAllRestaurants();
}
