package com.diancan.service.resto;

import com.diancan.domain.resto.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe findOne(Long id);

    List<Recipe> findMultipleByDialingTable_NumAndDialingTable_IsBooked(Integer num, Boolean isBooked);

    List<Recipe> findMultipleByPriceGreaterThanEqual(Integer price);

    List<Recipe> findMultipleByNameIsLike(String name);

    List<Recipe> findMultipleByRankGreaterThanEqual(Integer rank);
}
