package com.diancan.service.resto;

import com.diancan.domain.resto.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {

    RecipeCategory getOne(Long id);

    List<RecipeCategory> getMultipeByNameMatch(String name,String nameCn,String nameEn);

    List<RecipeCategory> getMultipeByDescMatch(String descInfo,String descCn,String descEn);

    void deleteMutipleByNameMatch(String name,String nameCn,String nameEn);

    void deleteMultipeByDescInfoMatch(String descInfo,String descCn,String descEn);

    void deleteOneByCode(String code);

    RecipeCategory updateOne(Long id,RecipeCategory recipeCategory);

    RecipeCategory addNewOne(RecipeCategory recipeCategory);

    List<RecipeCategory> getAll();
}
