package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.RecipeCategory;

import com.diancan.service.resto.RecipeCategoryServiceImpl;
import com.diancan.web.resto.controllers.common.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("get recipe categories by name like")
    @GetMapping("/byName")
    public List<RecipeCategory> getMultipleByNameMatch(
            @RequestParam("name") String name,
            @RequestParam("nameCn") String nameCn,
            @RequestParam("nameEn") String nameEn) {

        return  recipeCategoryService.getMultipeByNameMatch(name,nameCn,nameEn);
    }

    @ApiOperation("get recipe categories by desc like")
    @GetMapping("/byDescInfo")
    public List<RecipeCategory> getMultipleByDescMatch(
            @RequestParam("descInfo") String descInfo,
            @RequestParam("descCn") String descCn,
            @RequestParam("descEn") String descEn) {

        return  recipeCategoryService.getMultipeByDescMatch(descInfo,descCn,descEn);
    }

    @ApiOperation("get one by given id")
    @GetMapping("/{id}")
    public  RecipeCategory getOneById(
            @PathVariable("id") Long id) {

        return  recipeCategoryService.getOne(id);
    }

    @ApiOperation("delete recipe categories by name like")
    @DeleteMapping ("/byName")
    public ResponseEntity<CommonResponse> deleteMutlipeByNameMatch(
            @RequestParam("name") String name,
            @RequestParam("nameCn") String nameCn,
            @RequestParam("nameEn") String nameEn) {

        recipeCategoryService.deleteMutipleByNameMatch(name,nameCn,nameEn);

        CommonResponse commonResponse =new CommonResponse(HttpStatus.OK.value(),"multiple data has been removed!");

        return  ResponseEntity.ok(commonResponse);
    }

    @ApiOperation("delete recipe categories by descinfo like")
    @DeleteMapping ("/byDescInfo")
    public ResponseEntity<CommonResponse> deleteMultipleByDescMatch(
            @RequestParam("descInfo") String descInfo,
            @RequestParam("descCn") String descCn,
            @RequestParam("descEn") String descEn) {

        recipeCategoryService.deleteMultipeByDescInfoMatch(descInfo,descCn,descEn);

        CommonResponse commonResponse =new CommonResponse(HttpStatus.OK.value(),"multiple data has been removed!");

        return  ResponseEntity.ok(commonResponse);
    }

    @ApiOperation("update recipe categories by given id")
    @PutMapping ("/{id}")
    public  RecipeCategory updateOne(
            @PathVariable("id") Long id,
            @RequestBody() RecipeCategory newOne) {

      return   recipeCategoryService.updateOne(id,newOne);
    }

    @ApiOperation("add one one recipe category")
    @PostMapping
    public RecipeCategory addNewOne(
            @RequestBody RecipeCategory recipeCategory) {
         return  recipeCategoryService.addNewOne(recipeCategory);
    }
}
