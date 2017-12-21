package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.Drink;
import com.diancan.domain.resto.constants.DrinkCategory;
import com.diancan.domain.resto.constants.DrinkTeste;
import com.diancan.respositorys.DrinkRepository;
import com.diancan.service.resto.DrinkServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/drinks")
@Api(value = "drinks")
public class DrinkController {

    @Autowired
    DrinkServiceImpl drinkService;

    @ApiOperation(value = "getAllDrinks")
    @GetMapping(name="getAllDrinks",value = "getAllDrinks")
    public List<Drink> getAllDrinks() {

        return  drinkService.findAll();
    }

    /**
     *
     * @param vendor
     * @return
     */
    @ApiOperation(value = "get drinks vendor like")
    @ApiImplicitParam(value = "vendor",name="vendor",dataType = "String", paramType = "path")
    @GetMapping(name="getDrinksByGivenVendor",path = "/vendor/{vendor}")
    public List<Drink> getDrinksByGivenVendor(
            @PathVariable(value = "vendor",name = "vendor",required = true)
            String vendor) {

        return  drinkService.findMultipleByVendor(vendor);
    }

    /**
     *
     * @param descInfo
     * @return
     */
    @ApiOperation(value = "get drinks descinfo like")
    @ApiImplicitParam(value = "desc",name="desc",dataType = "String", paramType = "path")
    @GetMapping(name="getDrinksByGivenDescLike",path = "/desc/{desc}")
    public List<Drink> getDrinksByGivenDescLike(
            @PathVariable(value = "desc",name = "desc",required = true)
            String descInfo) {
        return  drinkService.findMultipleByDescIsLike(descInfo);
    }

    /**
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "get drinks name like")
    @ApiImplicitParam(value = "name",name="name",dataType = "String", paramType = "path")
    @GetMapping(name="getDrinksByGivenNameLike",path = "/name/{name}")
    public List<Drink> getDrinksByGivenNameLike(
            @PathVariable(value = "name",name = "name",required = true)
                    String name) {
        return  drinkService.findMultipleByNameIsLike(name);
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "find one drink by given id")
    @ApiImplicitParam(value = "id",name="id",dataType = "Long", paramType = "path")
    @GetMapping(name="findOneById",path = "/{id}")
    public Drink findOneById(
            @PathVariable(value = "id",name = "id",required = true)
                    Long id) {
        return  drinkService.findOneById(id);
    }

    /**
     *
     * @param rank
     * @return
     */
    @ApiOperation(value = "get drinks by rank bigger and equal than")
    @ApiImplicitParam(value = "rank",name="rank",dataType = "Integer", paramType = "path")
    @GetMapping(name="getDrinksByGivenRankGraterThan",path = "/rank/{rank}")
    public List<Drink> getDrinksByGivenRankGraterThan(
            @PathVariable(value = "rank",name = "rank",required = true)
                    Integer rank) {
        return  drinkService.findMultipeByRankGreaterThanEqual(rank);
    }

    /**
     *
     * @param price
     * @return
     */
    @ApiOperation(value = "get drinks by price bigger and equal than")
    @ApiImplicitParam(value = "price",name="price",dataType = "Integer", paramType = "path")
    @GetMapping(name="getDrinksByGivenPriceGraterThan",path = "/price/{price}")
    public List<Drink> getDrinksByGivenPriceGraterThan(
            @PathVariable(value = "price",name = "price",required = true)
                    Integer price) {
        return  drinkService.findMultipleByPriceGreaterThanEqual(price);
    }

    /**
     *
     * @param teste
     * @return
     */
    @ApiOperation(value = "get drinks by given drink teste")
    @ApiImplicitParam(value = "teste",name="teste",dataType = "Integer", paramType = "path")
    @GetMapping(name="getDrinksByGivenTeste",path = "/teste/{teste}")
    public List<Drink> getDrinksByGivenTeste(
            @PathVariable(value = "teste",name = "teste",required = true)
                    DrinkTeste teste) {
        return  drinkService.findMutlipleByDrinkTesteEquals(teste);
    }

    /**
     *
     * @param category
     * @return
     */
    @ApiOperation(value = "get drinks by given drink category")
    @ApiImplicitParam(value = "category",name="category",dataType = "Integer", paramType = "path")
    @GetMapping(name="getDrinksByGivenCategory",path = "/category/{category}")
    public List<Drink> getDrinksByGivenCategory(
            @PathVariable(value = "category",name = "category",required = true)
                    DrinkCategory category) {
        return  drinkService.findMultipleByDrinkCategoryEquals(category);
    }
}
