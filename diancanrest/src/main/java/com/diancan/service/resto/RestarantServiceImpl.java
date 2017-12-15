package com.diancan.service.resto;

import com.diancan.domain.resto.Restaurant;
import com.diancan.domain.resto.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestarantServiceImpl implements RestarantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Override
    public Restaurant findRestaurantById(Integer id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public List<Restaurant> findRestaurantByGivenAdress(String address) {
        return restaurantRepository.findRestaurantsByRestoAddressContains(address);
    }

    @Override
    public void delRestaurantById(Integer id) {
         restaurantRepository.delete(id);
    }

    @Override
    public Restaurant addNewRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findRestaurantByGivenRating(Integer rating) {
        return restaurantRepository.findRestaurantsByRatingGreaterThanEqual(rating);
    }
}
