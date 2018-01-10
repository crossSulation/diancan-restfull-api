package com.diancan.service.resto;

import com.diancan.domain.resto.DrinkCategory;
import com.diancan.respositorys.DrinkCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkCategoryServiceImpl implements DrinkCategoryService {

    @Autowired
    DrinkCategoryRepository drinkCategoryRepository;

    @Override
    public DrinkCategory getOne(Long id) {
        return drinkCategoryRepository.findOne(id);
    }

    @Override
    public List<DrinkCategory> getMultipeByNameMatch(String name, String nameEn, String nameCn) {
        return drinkCategoryRepository.findDrinkCategoriesByNameMatch(name,nameCn,nameEn);
    }

    @Override
    public List<DrinkCategory> getMultipeByDescMatch(String descInfo, String descEn, String descCn) {
        return drinkCategoryRepository.findDrinkCategoriesByDescriptionMatch(descInfo,descCn,descEn);
    }

    @Override
    public DrinkCategory findOneByCode(String code) {
        return drinkCategoryRepository.findDrinkCategoryByCodeIs(code);
    }

    @Override
    public void deleteMutipleByNameMatch(String name, String nameEn, String nameCn) {
        drinkCategoryRepository.deleteDrinkCategoriesByNameMatche(name,nameEn,nameCn);
    }

    @Override
    public void deleteMultipeByDescInfoMatch(String descInfo, String descEn, String descCn) {
      drinkCategoryRepository.deleteDrinkCategoriesByDescriptionMatche(descInfo,descCn,descEn);
    }

    @Override
    public void deleteOneById(Long id) {
        drinkCategoryRepository.delete(id);
    }

    @Override
    public DrinkCategory updateOne(Long id, DrinkCategory newDrinkCategory) {
        DrinkCategory drinkCategory = drinkCategoryRepository.findOne(id);
        if(drinkCategory!=null) {
            newDrinkCategory.setId(id);
            drinkCategoryRepository.save(newDrinkCategory);
        }
        return newDrinkCategory ;
    }

    @Override
    public DrinkCategory addNewOne(DrinkCategory newDrinkCategory) {
        return drinkCategoryRepository.save(newDrinkCategory);
    }

    @Override
    public void deleteOneByCode(String code) {
       drinkCategoryRepository.deleteDrinkCategoryByCode(code);
    }

    public List<DrinkCategory> getAll() {
        return  drinkCategoryRepository.findAll();
    }
}
