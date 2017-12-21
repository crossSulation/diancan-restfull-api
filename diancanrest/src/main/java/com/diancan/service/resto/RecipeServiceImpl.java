package com.diancan.service.resto;

import com.diancan.domain.resto.Recipe;
import com.diancan.respositorys.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe findOne(Long id) {
        return recipeRepository.findOne(id);
    }

    @Override
    public List<Recipe> findMultipleByDialingTable_NumAndDialingTable_IsBooked(Integer num, Boolean isBooked) {
        return recipeRepository.findRecipeByDialingTableRecipe_NumAndDialingTableRecipe_IsBooked(num,isBooked);
    }

    @Override
    public List<Recipe> findMultipleByPriceGreaterThanEqual(Integer price) {
        return recipeRepository.findRecipesByPriceGreaterThanEqual(price);
    }

    @Override
    public List<Recipe> findMultipleByNameIsLike(String name) {
        return recipeRepository.findRecipesByNameIsLike(name);
    }

    @Override
    public List<Recipe> findMultipleByRankGreaterThanEqual(Integer rank) {
        return recipeRepository.findRecipesByRankGreaterThanEqual(rank);
    }

    public  List<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}
