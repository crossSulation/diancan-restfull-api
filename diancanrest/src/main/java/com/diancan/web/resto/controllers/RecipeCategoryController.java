package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.RecipeCategory;

import com.diancan.service.resto.RecipeCategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipecategories")
@Api(value = "recipe categories",description = "recipe categories")
public class RecipeCategoryController {

    @Autowired
    RecipeCategoryServiceImpl recipeCategoryService;

    @ApiOperation("Get all recipe categories")
    @GetMapping
    public List<RecipeCategory> getAll() {
       return recipeCategoryService.getAll();
    }
}
