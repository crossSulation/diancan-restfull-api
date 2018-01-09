package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.DrinkCategory;
import com.diancan.service.resto.DrinkCategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drinkcategories")
@Api("Drink Categories")
public class DrinkCategoryController {

    @Autowired
    DrinkCategoryServiceImpl drinkCategoryService;

    @ApiOperation("get all drink categories")
    @GetMapping
    public List<DrinkCategory> getAll() {
        return  drinkCategoryService.getAll();
    }
}
