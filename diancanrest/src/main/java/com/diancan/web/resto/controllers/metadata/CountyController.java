package com.diancan.web.resto.controllers.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.County;
import com.diancan.service.resto.metadata.CountyServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/counties")
public class CountyController {

    @Autowired
    CountyServiceImpl countyService;

    @ApiOperation(value = "get county by given name")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
    @GetMapping(path = "/{id}")
    public County getOneByGivenId(Long id) {

        return  countyService.findOneByGivenId(id);
    }

    @ApiOperation(value = "get county by given name")
    @ApiImplicitParam(name = "name",value = "name",dataType = "String", paramType="path")
    @GetMapping(path = "/name/{name}")
    public List<County> getMultipleByName(String name) {
        return  countyService.findMultipleByGivenName(name);
    }

    @ApiOperation(value = "get county by given code")
    @ApiImplicitParam(name = "code",value = "code",dataType = "String", paramType="path")
    @GetMapping(path = "/code/{code}")
    public  List<County> getMultipleByCode(String code) {
        return  countyService.findMultipleByGivenCode(code);
    }

    @ApiOperation(value = "get county by given cityId")
    @ApiImplicitParam(name = "cityId",value = "cityId",dataType = "String", paramType="path")
    @GetMapping(path = "/city/{cityId}")
    public  List<County> getMultipleByCity(Long cityId) {
        return  countyService.findMultipleByGivenCity(cityId);
    }

    @ApiOperation(value = "get county by given descInfo")
    @ApiImplicitParam(name = "desc",value = "desc",dataType = "String", paramType="path")
    @GetMapping(path = "/desc/{desc}")
    public  List<County> getMultipleByDesc(
            @PathVariable(name = "desc",value = "desc") String desc) {
        return  countyService.findMultipleByGivenDesc(desc);
    }

    /**
     *
     * @param county
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "county",value = "county",dataType = "County", paramType="body")
    @PostMapping
    public County addNewOne(
            @RequestBody() County county) {
        return countyService.addNewOne(county);
    }

    /**
     *
     * @param county
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "county",value = "county",dataType = "County", paramType="body")
    @PutMapping
    public County updateOne(
            @RequestBody() County county) {
        return  countyService.updateOne(county);
    }

    /**
     *
     * @param id
     */
    @ApiOperation(value = "delete one by id")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
    @DeleteMapping("/{id}")
    public  void deleteOneByGivenId(
            @PathVariable(value = "id",name="id") Long id) {
        countyService.deleteOne(id);
    }

    /**
     *
     */
    @ApiOperation(value = "delete one by id")
    @DeleteMapping
    public  void deleteAll() {
        countyService.deleteAll();
    }
}
