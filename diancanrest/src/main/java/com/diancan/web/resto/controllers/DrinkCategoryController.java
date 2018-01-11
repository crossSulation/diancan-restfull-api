package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.DrinkCategory;
import com.diancan.service.resto.DrinkCategoryServiceImpl;
import com.diancan.web.resto.controllers.common.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CommonResponse> deleteOneByCode(
            @PathVariable("code") String code) {
        drinkCategoryService.deleteOneByCode(code);
        CommonResponse response = new CommonResponse(HttpStatus.OK.value(),"the resource has been deleted successfully!");
        return  ResponseEntity.ok(response);
    }

    @ApiOperation("delete drink categories by id is")
    @DeleteMapping("/{id}")
    public  ResponseEntity<CommonResponse> deleteOneById(
            @PathVariable("id") Long id) {
        drinkCategoryService.deleteOneById(id);
        CommonResponse response = new CommonResponse(HttpStatus.OK.value(),"the resource has been deleted successfully!");
        return  ResponseEntity.ok(response);
    }

    @ApiOperation("delete multiple drink categories by name like ")
    @DeleteMapping("/byName")
    public ResponseEntity<CommonResponse> deleteMultipleByNameMatch(
            @RequestParam("name") String name,
            @RequestParam("nameCn") String nameCn,
            @RequestParam("nameEn") String nameEn) {
         drinkCategoryService.deleteMutipleByNameMatch(name,nameEn,nameCn);
        CommonResponse response = new CommonResponse(HttpStatus.OK.value(),"the resource has been deleted successfully!");
        return  ResponseEntity.ok(response);
    }

    @ApiOperation("delete multiple drink categories by name like ")
    @DeleteMapping("/byDescInfo")
    public ResponseEntity<CommonResponse> deleteMultipleByDescatch(
            @RequestParam("descInfo") String descInfo,
            @RequestParam("descCn") String descCn,
            @RequestParam("descEn") String descEn) {
        drinkCategoryService.deleteMultipeByDescInfoMatch(descInfo,descCn,descEn);
        CommonResponse response = new CommonResponse(HttpStatus.OK.value(),"the resource has been deleted successfully!");
        return  ResponseEntity.ok(response);
    }

    @ApiOperation("update one by given id ")
    @PutMapping("/{id}")
    public  ResponseEntity<CommonResponse> updateOne(
            @PathVariable("id") Long id,
            @RequestBody() DrinkCategory drinkCategory) {
         drinkCategoryService.updateOne(id,drinkCategory);
        CommonResponse response = new CommonResponse(HttpStatus.OK.value(),"the resource has been updated successfully!");
        return  ResponseEntity.ok(response);
    }

    @ApiOperation("add new one")
    @PostMapping
    public  ResponseEntity<DrinkCategory> addNewOne(
            @RequestHeader(value = "sm_user",required = false) String sm_user,
            @RequestBody() DrinkCategory drinkCategory) {
           DrinkCategory newdrinkC = drinkCategoryService.addNewOne(drinkCategory);
        return  ResponseEntity.ok(newdrinkC);
    }
}
