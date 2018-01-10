package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.DrinkCategory;
import com.diancan.service.resto.DrinkCategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinkcategories")
@Api("Drink Categories")
public class DrinkCategoryController {

    @Autowired
    DrinkCategoryServiceImpl drinkCategoryService;

    @ApiOperation("get all drink categories")
    @GetMapping("/")
    public List<DrinkCategory> getAll() {
        return  drinkCategoryService.getAll();
    }

    @ApiOperation("Get drink categories by name like")
    @GetMapping("/byName")
    public List<DrinkCategory> getDrinkCategoriesByNameMacth(
            @RequestParam("name") String name,
            @RequestParam("nameCn") String nameCn,
            @RequestParam("nameEn") String nameEn) {

        return drinkCategoryService.getMultipeByNameMatch(name,nameEn,nameCn);
    }

    @ApiOperation("Get drink categories by description info  like")
    @GetMapping("/byDescInfo")
    public List<DrinkCategory> getDrinkCategoriesByDescmatch(
            @RequestParam("descinfo") String descinfo,
            @RequestParam("descCn") String descCn,
            @RequestParam("descEn") String descEn) {

        return  drinkCategoryService.getMultipeByDescMatch(descinfo,descEn,descCn);
    }

    @ApiOperation("Get drink categories by code is")
    @GetMapping("/code/{code}")
    public  DrinkCategory getDrinkCategoryByCode(
            @PathVariable("code") String code) {
        return  drinkCategoryService.findOneByCode(code);
    }

    @ApiOperation("delete drink categories by code is")
    @DeleteMapping("/code/{code}")
    public ResponseEntity deleteOneByCode(
            @PathVariable("code") String code) {
        drinkCategoryService.deleteOneByCode(code);

        return  ResponseEntity.ok().body(null);
    }

    @ApiOperation("delete drink categories by id is")
    @DeleteMapping("/{id}")
    public  ResponseEntity deleteOneById(
            @PathVariable("id") Long id) {
        drinkCategoryService.deleteOneById(id);
        return  ResponseEntity.ok().body(null);
    }

    @ApiOperation("delete multiple drink categories by name like ")
    @DeleteMapping("/byName")
    public ResponseEntity deleteMultipleByNameMatch(
            @RequestParam("name") String name,
            @RequestParam("nameCn") String nameCn,
            @RequestParam("nameEn") String nameEn) {
         drinkCategoryService.deleteMutipleByNameMatch(name,nameEn,nameCn);
        return  ResponseEntity.ok().body(null);
    }

    @ApiOperation("delete multiple drink categories by name like ")
    @DeleteMapping("/byDescInfo")
    public ResponseEntity deleteMultipleByDescatch(
            @RequestParam("descInfo") String descInfo,
            @RequestParam("descCn") String descCn,
            @RequestParam("descEn") String descEn) {
        drinkCategoryService.deleteMultipeByDescInfoMatch(descInfo,descCn,descEn);
        return  ResponseEntity.ok().body(null);
    }

    @ApiOperation("update one by given id ")
    @PutMapping("/{id}")
    public  ResponseEntity updateOne(
            @PathVariable("id") Long id,
            @RequestBody() DrinkCategory drinkCategory) {
         drinkCategoryService.updateOne(id,drinkCategory);
        return  ResponseEntity.ok().body(null);
    }

    @ApiOperation("add new one")
    @PostMapping
    public  ResponseEntity addNewOne(
            @RequestBody() DrinkCategory drinkCategory) {
       DrinkCategory newdrinkC = drinkCategoryService.addNewOne(drinkCategory);

        return  ResponseEntity.ok().body(newdrinkC);
    }
}
