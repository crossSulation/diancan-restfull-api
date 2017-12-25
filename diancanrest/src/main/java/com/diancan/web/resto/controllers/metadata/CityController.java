package com.diancan.web.resto.controllers.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.service.resto.metadata.CityServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    CityServiceImpl cityService;


    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "get city by given id")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
    @GetMapping(path = "/{id}")
    public City getOneByGivenId(Long id) {
      return  cityService.findOneByGivenId(id);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "get all cities")
    @GetMapping
    public List<City> getAll() {
        return  cityService.findAll();
    }
    /**
     *
     * @param provinceId
     * @return
     */
    @ApiOperation(value = "get city by given provinceId")
    @ApiImplicitParam(name = "provinceId",value = "provinceId",dataType = "Long", paramType="path")
    @GetMapping(path = "/province/{provinceId}")
    public List<City> getMultipleByGivenProvince(Long provinceId) {
        return  cityService.findMultipleByGivenProvince(provinceId);
    }

    /**
     *
     * @param code
     * @return
     */
    @ApiOperation(value = "get city by given code")
    @ApiImplicitParam(name = "code",value = "code",dataType = "String", paramType="path")
    @GetMapping(path = "/code/{code}")
    public List<City> getMultipleByGivenCode(String code) {
        return  cityService.findMultipleByGivenCode(code);
    }

    /**
     *
     * @param desc
     * @return
     */
    @ApiOperation(value = "get city by given descInfo")
    @ApiImplicitParam(name = "desc",value = "desc",dataType = "String", paramType="path")
    @GetMapping(path = "/desc/{desc}")
    public List<City> getMultipleByGivenDesc(
            @PathVariable(value = "desc",name = "desc") String desc) {
        return  cityService.findMultipleByGivenDesc(desc);
    }

    /**
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "get city by given name")
    @ApiImplicitParam(name = "name",value = "name",dataType = "String", paramType="path")
    @GetMapping(path = "/name/{name}")
    public List<City> getMultipleByGivenName(
            @PathVariable(value = "name",name = "name") String name) {

        return  cityService.findMultipleByGivenName(name);
    }

    /**
     *
     * @param city
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "city",value = "city",dataType = "City", paramType="body")
    @PostMapping
    public City addNewOne(
            @RequestBody() City city) {
        return cityService.addNewOne(city);
    }

    /**
     *
     * @param city
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "city",value = "city",dataType = "City", paramType="body")
    @PutMapping
    public City updateOne(
            @RequestBody() City city) {
        return  cityService.updateOne(city);
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
         cityService.deleteOne(id);
    }

    /**
     *
     */
    @ApiOperation(value = "delete one by id")
    @DeleteMapping
    public  void deleteAll() {
        cityService.deleteAll();
    }
}
