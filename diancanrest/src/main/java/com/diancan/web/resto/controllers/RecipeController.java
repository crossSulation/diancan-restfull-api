package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.Recipe;
import com.diancan.service.resto.RecipeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeService;

    @ApiOperation(value = "getAllRecipes")
    @GetMapping(name="getAllRecipes",value = "getallrecipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    /**
     *
     * @param price
     * @return
     */
    @ApiOperation(value = "get recipes grater and equal than given price")
    @ApiImplicitParam(value = "price",name="price",dataType = "Integer", paramType = "path",defaultValue = "0")
    @GetMapping(name="getRecipesGraterByGivenPrice",path = "/price/{price}")
    public List<Recipe> getRecipesGraterByGivenPrice(@PathVariable(name = "price",required = true,value="price") Integer price) {
        return  recipeService.findMultipleByPriceGreaterThanEqual(price);
    }

    /**
     *
     * @param rank
     * @return
     */
    @ApiOperation(value = "get recipes grater and equal than given rank")
    @ApiImplicitParam(value = "rank",name="rank",dataType = "Integer", paramType = "path",defaultValue = "0")
    @GetMapping(name="getRecipesGraterThanByGivenRank",path = "/rank/{rank}")
    public List<Recipe> getRecipesGraterThanByGivenRank(
            @PathVariable(name = "rank",required = true,value="rank")
            Integer rank) {
        return recipeService.findMultipleByRankGreaterThanEqual(rank);
    }

    /**
     *
     * @param recipeName
     * @return
     */
    @ApiOperation(value = "get recipes given name like")
    @ApiImplicitParam(value = "recipename",name="recipename",dataType = "String", paramType = "path")
    @GetMapping(name="getRecipesByGivenNameLike",path = "/name/{rank}")
    public List<Recipe> getRecipesByGivenNameLike(
            @PathVariable(name = "recipeName",required = true,value="recipeName")
            String recipeName) {
         return recipeService.findMultipleByNameIsLike(recipeName);
    }

    /**
     *
     * @param recipe
     * @return
     */
    @ApiOperation(value = "add a new recipe")
    @ApiImplicitParam(value = "recipe",name="recipe",dataType = "Recipe", paramType = "body")
    @RequestMapping(method =RequestMethod.POST)
    public Recipe addNewRecipe(
            @RequestBody(required = true) Recipe recipe
    ) {
        return recipeService.addOne(recipe);
    }

    /**
     *
     * @param id
     */
    @ApiOperation(value = "delete a recipe")
    @ApiImplicitParam(value = "id",name="id",dataType = "Long", paramType = "path")
    @RequestMapping(method =RequestMethod.DELETE)
    public  void delOneRecipe(
            @PathVariable(name = "id",required = true,value="id") Long id
    ) {
        recipeService.deleteOne(id);
    }

    /**
     *
     * @param newRecipe
     * @return
     */
    @ApiOperation(value = "update a recipe")
    @ApiImplicitParam(value = "recipe",name="recipe",dataType = "Recipe", paramType = "body")
    @RequestMapping(method =RequestMethod.PUT)
    public  Recipe updateOne(
            @RequestBody(required = true) Recipe newRecipe
    ) {

        return  recipeService.updateOne(newRecipe);
    }
}
