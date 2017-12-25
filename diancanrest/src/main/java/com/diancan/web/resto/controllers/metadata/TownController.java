package com.diancan.web.resto.controllers.metadata;

import com.diancan.domain.resto.metadata.Street;
import com.diancan.domain.resto.metadata.Town;
import com.diancan.service.resto.metadata.StreetServiceImpl;
import com.diancan.service.resto.metadata.TownServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

        @Autowired
        TownServiceImpl townService;
        /**
         *
         * @param id
         * @return
         */
        @ApiOperation(value = "get town by given name")
        @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
        @GetMapping(path = "/{id}")
        public Town getOneByGivenId(Long id) {

            return  townService.findOneByGivenId(id);
        }

        /**
         *
         * @return
         */
        @ApiOperation(value = "get all towns")
        @GetMapping
        public List<Town> getAll() {
            return townService.findAll();
        }

        /**
         *
         * @param name
         * @return
         */
        @ApiOperation(value = "get town by given name")
        @ApiImplicitParam(name = "name",value = "name",dataType = "String", paramType="path")
        @GetMapping(path = "/name/{name}")
        public List<Town> getMultipleByName(String name) {
            return  townService.findMultipleByGivenName(name);
        }

        /**
         *
         * @param code
         * @return
         */
        @ApiOperation(value = "get city by given code")
        @ApiImplicitParam(name = "code",value = "code",dataType = "String", paramType="path")
        @GetMapping(path = "/code/{code}")
        public  List<Town> getMultipleByCode(String code) {
            return  townService.findMultipleByGivenCode(code);
        }

        /**
         *
         * @param countyId
         * @return
         */
        @ApiOperation(value = "get city by given countyId")
        @ApiImplicitParam(name = "countyId",value = "countyId",dataType = "Long", paramType="path")
        @GetMapping(path = "/county/{countyId}")
        public  List<Town> getMultipleByCity(Long countyId) {
            return  townService.findMultipleByGivenCounty(countyId);
        }

        /**
         *
         * @param desc
         * @return
         */
        @ApiOperation(value = "get county by given descInfo")
        @ApiImplicitParam(name = "desc",value = "desc",dataType = "String", paramType="path")
        @GetMapping(path = "/desc/{desc}")
        public  List<Town> getMultipleByDesc(
                @PathVariable(name = "desc",value = "desc") String desc) {
            return  townService.findMultipleByGivenDesc(desc);
        }

        /**
         *
         * @param town
         * @return
         */
        @ApiOperation(value = "add new one")
        @ApiImplicitParam(name = "town",value = "town",dataType = "Town", paramType="body")
        @PostMapping
        public Town addNewOne(
                @RequestBody() Town town) {
            return townService.addNewOne(town);
        }

        /**
         *
         * @param town
         * @return
         */
        @ApiOperation(value = "update one")
        @ApiImplicitParam(name = "town",value = "town",dataType = "Town", paramType="body")
        @PutMapping
        public Town updateOne(
                @RequestBody() Town town) {
            return  townService.updateOne(town);
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
            townService.deleteOneById(id);
        }

        /**
         *
         */
        @ApiOperation(value = "delete all")
        @DeleteMapping
        public  void deleteAll() {
            townService.deleteAll();
        }
    }
