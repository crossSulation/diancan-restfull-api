package com.diancan.respositorys;

import com.diancan.domain.resto.Drink;
import com.diancan.domain.resto.constants.DrinkCategory;
import com.diancan.domain.resto.constants.DrinkTeste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink,Long> {

    Drink findOne(Long id);

    Drink findDrinkById(Long id);

    List<Drink>  findDrinksByDescIsLike(String descInfo);

    List<Drink>  findDrinksByNameIsLike(String name);

    @Query("select d from Drink d where d.vendor like ?1%")
    List<Drink> findDrinksByVendor(String vendor);

    List<Drink> findDrinksByDialingTableDrink_NumAndDialingTableDrink_IsBooked(Integer num,Boolean isBooked);

    List<Drink> findDrinksByDrinkTesteEquals(DrinkTeste drinkTeste);

    List<Drink> findDrinksByDrinkCategoryEquals(DrinkCategory drinkCategory);

    List<Drink> findDrinksByRankGreaterThanEqual(Integer rank);

    List<Drink> findDrinksByPriceGreaterThanEqual(Integer price);
}
