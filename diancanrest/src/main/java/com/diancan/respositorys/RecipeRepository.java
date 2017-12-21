package com.diancan.respositorys;

import com.diancan.domain.resto.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    Recipe findOne(Long id);

    List<Recipe> findRecipeByDialingTableRecipe_NumAndDialingTableRecipe_IsBooked(Integer num,Boolean isBooked);

    List<Recipe> findRecipesByPriceGreaterThanEqual(Integer price);

    List<Recipe> findRecipesByNameIsLike(String name);

    List<Recipe> findRecipesByRankGreaterThanEqual(Integer rank);
}
