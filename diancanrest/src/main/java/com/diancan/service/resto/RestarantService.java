package com.diancan.service.resto;

import com.diancan.domain.resto.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestarantService {

    Restaurant findRestaurantById(Integer id);

    List<Restaurant> findRestaurantByGivenAdress(String address);

    List<Restaurant> findRestaurantByGivenRating(Integer rating);

    void delRestaurantById(Integer id);

    Restaurant addNewRestaurant(Restaurant restaurant);

    List<Restaurant>  getAllRestaurants();
}
