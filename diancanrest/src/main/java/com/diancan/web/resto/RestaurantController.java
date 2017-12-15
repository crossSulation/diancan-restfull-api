package com.diancan.web.resto;

import com.diancan.domain.resto.Restaurant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restoinfo")
public class RestaurantController {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Restaurant getRestaurantById(@PathVariable long id) {

        return  null;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return  null;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Boolean addNewRestoBasicInfo(
            @RequestBody() String jonstr
    ) {
        return  false;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public boolean delOneRestaurantById(@PathVariable long id) {
        return  false;
    }
}
