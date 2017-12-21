package com.diancan.service.resto;

import com.diancan.domain.resto.Drink;
import com.diancan.domain.resto.constants.DrinkCategory;
import com.diancan.domain.resto.constants.DrinkTeste;
import com.diancan.respositorys.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    @Override
    public Drink findOneById(Long id) {
        return drinkRepository.findDrinkById(id);
    }

    @Override
    public List<Drink> findMultipleByDescIsLike(String descInfo) {
        return drinkRepository.findDrinksByDescIsLike(descInfo);
    }

    @Override
    public List<Drink> findMultipleByNameIsLike(String name) {
        return drinkRepository.findDrinksByNameIsLike(name);
    }

    @Override
    public List<Drink> findMultipleByVendor(String vendor) {
        return drinkRepository.findDrinksByVendor(vendor);
    }

    @Override
    public List<Drink> findMultipleByDialingTable_NumAndDialingTable_IsBooked(Integer num, Boolean isBooked) {
        return drinkRepository.findDrinksByDialingTableDrink_NumAndDialingTableDrink_IsBooked(num,isBooked);
    }

    @Override
    public List<Drink> findMutlipleByDrinkTesteEquals(DrinkTeste drinkTeste) {
        return drinkRepository.findDrinksByDrinkTesteEquals(drinkTeste);
    }

    @Override
    public List<Drink> findMultipleByDrinkCategoryEquals(DrinkCategory drinkCategory) {
        return drinkRepository.findDrinksByDrinkCategoryEquals(drinkCategory);
    }

    public List<Drink> findAll() {
        return  drinkRepository.findAll();
    }

    @Override
    public List<Drink> findMultipeByRankGreaterThanEqual(Integer rank) {
        return drinkRepository.findDrinksByRankGreaterThanEqual(rank);
    }

    @Override
    public List<Drink> findMultipleByPriceGreaterThanEqual(Integer price) {
        return drinkRepository.findDrinksByPriceGreaterThanEqual(price);
    }
}
