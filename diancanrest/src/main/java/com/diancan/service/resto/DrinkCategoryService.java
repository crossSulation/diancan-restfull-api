package com.diancan.service.resto;

import com.diancan.domain.resto.DrinkCategory;

import java.util.List;

public interface DrinkCategoryService {

    DrinkCategory getOne(Long id);

    List<DrinkCategory> getMultipeByNameMatch(String name,String nameEn,String nameCn);

    List<DrinkCategory> getMultipeByDescMatch(String descInfo, String descEn, String descCn);

    void deleteMutipleByNameMatch(String name,String nameEn,String nameCn);

    void deleteMultipeByDescInfoMatch(String descInfo,String descEn,String descCn);

    void deleteOneByCode(String code);

    DrinkCategory updateOne(Long id,DrinkCategory drinkCategory);

    DrinkCategory addNewOne(DrinkCategory drinkCategory);
}
