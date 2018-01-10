package com.diancan.service.resto;

import com.diancan.domain.resto.RecipeCategory;
import com.diancan.respositorys.RecipeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    @Autowired
    RecipeCategoryRepository recipeCategoryRepository;

    @Override
    public RecipeCategory getOne(Long id) {
        return recipeCategoryRepository.findOne(id);
    }

    @Override
    public List<RecipeCategory> getAll() {
        return recipeCategoryRepository.findAll();
    }

    @Override
    public List<RecipeCategory> getMultipeByNameMatch(String name, String nameCn, String nameEn) {
        return recipeCategoryRepository.findRecipeCategoriesByNameMatch(name,nameCn,nameEn);
    }

    @Override
    public List<RecipeCategory> getMultipeByDescMatch(String descInfo, String descCn, String descEn) {
        return recipeCategoryRepository.findRecipeCategoriesByDescriptionMatche(descInfo,descCn,descEn);
    }

    @Override
    public void deleteMutipleByNameMatch(String name, String nameCn, String nameEn) {
        recipeCategoryRepository.deleteRecipeCategoriesByNameMatche(name,nameCn,nameEn);
    }

    @Override
    public void deleteMultipeByDescInfoMatch(String descInfo, String descCn, String descEn) {
        recipeCategoryRepository.findRecipeCategoriesByDescriptionMatche(descInfo,descCn,descEn);
    }

    @Override
    public RecipeCategory updateOne(Long id, RecipeCategory newRecipeCategory) {
        RecipeCategory recipeCategory =recipeCategoryRepository.findOne(id);
        if(recipeCategory!=null) {
            newRecipeCategory.setId(id);
            recipeCategoryRepository.save(newRecipeCategory);
        }
        return newRecipeCategory;
    }

    @Override
    public RecipeCategory addNewOne(RecipeCategory recipeCategory) {
        return recipeCategoryRepository.save(recipeCategory);
    }

    @Override
    public void deleteOneByCode(String code) {
        recipeCategoryRepository.deleteRecipeCategoryByCode(code);
    }
}
