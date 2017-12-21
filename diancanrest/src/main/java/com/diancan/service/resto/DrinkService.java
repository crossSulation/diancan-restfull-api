package com.diancan.service.resto;

import com.diancan.domain.resto.Drink;
import com.diancan.domain.resto.constants.DrinkCategory;
import com.diancan.domain.resto.constants.DrinkTeste;

import java.util.List;

public interface DrinkService {

    Drink findOneById(Long id);

    List<Drink>  findMultipleByDescIsLike(String descInfo);

    List<Drink> findMultipleByNameIsLike(String name);

    List<Drink> findMultipleByVendor(String vendor);

    List<Drink> findMultipleByDialingTable_NumAndDialingTable_IsBooked(Integer num,Boolean isBooked);

    List<Drink> findMutlipleByDrinkTesteEquals(DrinkTeste drinkTeste);

    List<Drink> findMultipleByDrinkCategoryEquals(DrinkCategory drinkCategory);

    List<Drink> findMultipeByRankGreaterThanEqual(Integer rank);

    List<Drink> findMultipleByPriceGreaterThanEqual(Integer price);
}
