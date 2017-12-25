package com.diancan.web.resto.controllers.metadata;

import com.diancan.domain.resto.metadata.County;
import com.diancan.domain.resto.metadata.Province;
import com.diancan.service.resto.metadata.ProvinceServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/provinces")
public class ProvinceController {

    @Autowired
    ProvinceServiceImpl provinceService;

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "get province by given name")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
    @GetMapping(path = "/{id}")
    public Province getOneByGivenId(Long id) {

        return  provinceService.findOneByGivenId(id);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "get all provinces")
    @GetMapping
    public List<Province> getAll() {
        return provinceService.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "get province by given name")
    @ApiImplicitParam(name = "name",value = "name",dataType = "String", paramType="path")
    @GetMapping(path = "/name/{name}")
    public List<Province> getMultipleByName(String name) {
        return  provinceService.findMultipleByGivenName(name);
    }

    /**
     *
     * @param code
     * @return
     */
    @ApiOperation(value = "get province by given code")
    @ApiImplicitParam(name = "code",value = "code",dataType = "String", paramType="path")
    @GetMapping(path = "/code/{code}")
    public  List<Province> getMultipleByCode(String code) {
        return  provinceService.findMultipleByGivenCode(code);
    }


    /**
     *
     * @param desc
     * @return
     */
    @ApiOperation(value = "get province by given descInfo")
    @ApiImplicitParam(name = "desc",value = "desc",dataType = "String", paramType="path")
    @GetMapping(path = "/desc/{desc}")
    public  List<Province> getMultipleByDesc(
            @PathVariable(name = "desc",value = "desc") String desc) {
        return  provinceService.findMultipleByGivenDesc(desc);
    }

    /**
     *
     * @param province
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "province",value = "province",dataType = "Province", paramType="body")
    @PostMapping
    public Province addNewOne(
            @RequestBody() Province province) {
        return provinceService.addNewOne(province);
    }

    /**
     *
     * @param province
     * @return
     */
    @ApiOperation(value = "update  one")
    @ApiImplicitParam(name = "province",value = "province",dataType = "Province", paramType="body")
    @PutMapping
    public Province updateOne(
            @RequestBody() Province province) {
        return  provinceService.updateOne(province);
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
        provinceService.deleteOneById(id);
    }

    /**
     *
     */
    @ApiOperation(value = "delete all")
    @DeleteMapping
    public  void deleteAll() {
        provinceService.deleteAll();
    }
}
