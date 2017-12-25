package com.diancan.web.resto.controllers.metadata;

import com.diancan.domain.resto.metadata.County;
import com.diancan.domain.resto.metadata.Street;
import com.diancan.service.resto.metadata.StreetServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.StreamTokenizer;
import java.util.List;

@RestController
@RequestMapping(value = "/streets")
public class StreetController {


    @Autowired
    StreetServiceImpl streetService;
    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "get street by given name")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
    @GetMapping(path = "/{id}")
    public Street getOneByGivenId(Long id) {

        return  streetService.findOneByGivenId(id);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "get all streets")
    @GetMapping
    public List<Street> getAll() {
        return streetService.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "get city by given name")
    @ApiImplicitParam(name = "name",value = "name",dataType = "String", paramType="path")
    @GetMapping(path = "/name/{name}")
    public List<Street> getMultipleByName(String name) {
        return  streetService.findMultipleByGivenName(name);
    }

    /**
     *
     * @param code
     * @return
     */
    @ApiOperation(value = "get city by given code")
    @ApiImplicitParam(name = "code",value = "code",dataType = "String", paramType="path")
    @GetMapping(path = "/code/{code}")
    public  List<Street> getMultipleByCode(String code) {
        return  streetService.findMultipleByGivenCode(code);
    }

    /**
     *
     * @param townId
     * @return
     */
    @ApiOperation(value = "get city by given townId")
    @ApiImplicitParam(name = "townId",value = "townId",dataType = "Long", paramType="path")
    @GetMapping(path = "/town/{townId}")
    public  List<Street> getMultipleByCity(Long townId) {
        return  streetService.findMultipleByGivenTown(townId);
    }

    /**
     *
     * @param desc
     * @return
     */
    @ApiOperation(value = "get county by given descInfo")
    @ApiImplicitParam(name = "desc",value = "desc",dataType = "String", paramType="path")
    @GetMapping(path = "/desc/{desc}")
    public  List<Street> getMultipleByDesc(
            @PathVariable(name = "desc",value = "desc") String desc) {
        return  streetService.findMultipleByGivenDesc(desc);
    }

    /**
     *
     * @param street
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "street",value = "street",dataType = "Street", paramType="body")
    @PostMapping
    public Street addNewOne(
            @RequestBody() Street street) {
        return streetService.addNewOne(street);
    }

    /**
     *
     * @param street
     * @return
     */
    @ApiOperation(value = "update one")
    @ApiImplicitParam(name = "street",value = "street",dataType = "Street", paramType="body")
    @PutMapping
    public Street updateOne(
            @RequestBody() Street street) {
        return  streetService.updateOne(street);
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
        streetService.deleteOneById(id);
    }

    /**
     *
     */
    @ApiOperation(value = "delete all")
    @DeleteMapping
    public  void deleteAll() {
        streetService.deleteAll();
    }
}
