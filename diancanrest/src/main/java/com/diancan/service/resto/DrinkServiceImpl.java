package com.diancan.service.resto;

import com.diancan.domain.resto.Drink;
import com.diancan.domain.resto.constants.DrinkCategory;
import com.diancan.domain.resto.constants.DrinkTeste;
import com.diancan.respositorys.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Drink findOneById(Long id) {
        return drinkRepository.findDrinkById(id);
    }

    /**
     *
     * @param descInfo
     * @return
     */
    @Override
    public List<Drink> findMultipleByDescIsLike(String descInfo) {
        return drinkRepository.findDrinksByDescIsLike(descInfo);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Drink> findMultipleByNameIsLike(String name) {
        return drinkRepository.findDrinksByNameIsLike(name);
    }

    /**
     *
     * @param vendor
     * @return
     */
    @Override
    public List<Drink> findMultipleByVendor(String vendor) {
        return drinkRepository.findDrinksByVendor(vendor);
    }

    /**
     *
     * @param num
     * @param isBooked
     * @return
     */
    @Override
    public List<Drink> findMultipleByDialingTable_NumAndDialingTable_IsBooked(Integer num, Boolean isBooked) {
        return drinkRepository.findDrinksByDialingTableDrink_NumAndDialingTableDrink_IsBooked(num,isBooked);
    }

    /**
     *
     * @param drinkTeste
     * @return
     */
    @Override
    public List<Drink> findMutlipleByDrinkTesteEquals(DrinkTeste drinkTeste) {
        return drinkRepository.findDrinksByDrinkTesteEquals(drinkTeste);
    }

    /**
     *
     * @param drinkCategory
     * @return
     */
    @Override
    public List<Drink> findMultipleByDrinkCategoryEquals(DrinkCategory drinkCategory) {
        return drinkRepository.findDrinksByDrinkCategoryEquals(drinkCategory);
    }

    /**
     *
     * @return
     */
    public List<Drink> findAll() {
        return  drinkRepository.findAll();
    }

    /**
     *
     * @param rank
     * @return
     */
    @Override
    public List<Drink> findMultipeByRankGreaterThanEqual(Integer rank) {
        return drinkRepository.findDrinksByRankGreaterThanEqual(rank);
    }

    /**
     *
     * @param price
     * @return
     */
    @Override
    public List<Drink> findMultipleByPriceGreaterThanEqual(Integer price) {
        return drinkRepository.findDrinksByPriceGreaterThanEqual(price);
    }

    /**
     *
     * @param drink
     * @return
     */
    public Drink addNewOne(Drink drink) {
        return drinkRepository.save(drink);
    }

    /**
     *  delete one by given id
     * @param id
     */
    public void deleteOneByGivenId(Long id) {
        drinkRepository.delete(id);
    }

    public void deleteAll() {
        drinkRepository.deleteAll();
    }

    /**
     * update one
     * @param drink
     * @return
     */
    public Drink updateOne(Drink drink) {
       return drinkRepository.save(drink);
    }
}
