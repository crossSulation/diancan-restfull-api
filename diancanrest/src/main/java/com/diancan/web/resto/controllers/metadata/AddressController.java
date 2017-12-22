package com.diancan.web.resto.controllers.metadata;

import com.diancan.domain.resto.metadata.Address;
import com.diancan.service.resto.metadata.AddressServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

    /**
     *
     * @return
     */
    @ApiOperation(value = "get all addresses")
    @GetMapping
    public List<Address> getAll() {
        return  addressService.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "get address by given id")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Long", paramType="path")
    @GetMapping(path = "/{id}")
    public Address getOneByGivenId(
            @PathVariable(name = "id",value = "id",required = true) Long id) {
        return  addressService.findOneByGivenId(id);
    }

    /**
     *
     * @param address
     * @return
     */
    @ApiOperation(value = "add new one")
    @ApiImplicitParam(name = "addres",value = "address",dataType = "Address",paramType = "body")
    @PostMapping
    public Address addNewOne(
            @RequestBody(required = true) Address address) {
        return  addressService.addNewOne(address);
    }

    /**
     *
     * @param address
     * @return
     */

    @ApiOperation(value = "update one")
    @ApiImplicitParam(name = "addres",value = "address",dataType = "Address",paramType = "body")
    @PutMapping
    public  Address updateOne(
            @RequestBody(required = true) Address address) {
        return  addressService.updateOne(address);
    }

    /**
     *
     * @param id
     */
    @ApiOperation("delete one by given id")
    @ApiImplicitParam(name="id",value = "id",dataType = "Long",paramType = "path")
    @DeleteMapping(path = "/{id}")
    public void deleteOneByGivenId(
            @PathVariable(name = "id",value = "id",required = true) Long id) {
        addressService.deleteOneById(id);
    }

    /**
     *
     * @param provinceId
     * @return
     */
    @ApiOperation(value = "get address by given provinceId")
    @ApiImplicitParam(name = "provinceId",value = "provinceId",dataType = "Long", paramType="path")
    @GetMapping(path = "/province/{provinceId}")
    public  List<Address> getMultipleByProvince(
            @PathVariable(value = "provinceId",name = "provinceId") Long provinceId) {
        return addressService.findMultipleByGivenProvince(provinceId);
    }

    /**
     *
     * @param cityId
     * @return
     */
    @ApiOperation(value = "get address by given cityId")
    @ApiImplicitParam(name = "cityId",value = "cityId",dataType = "Long", paramType="path")
    @GetMapping(path = "/city/{cityId}")
    public  List<Address> getMultipleByCity(
            @PathVariable(value = "cityId",name = "cityId") Long cityId) {
        return  addressService.findMultipleByGivenCity(cityId);
    }

    /**
     *
     * @param countyId
     * @return
     */
    @ApiOperation(value = "get address by given countyId")
    @ApiImplicitParam(name = "countyId",value = "countyId",dataType = "Long", paramType="path")
    @GetMapping(path = "/county/{countyId}")
    public List<Address> getMultipleByCounty(
            @PathVariable(value = "countyId",name = "countyId") Long countyId) {
        return  addressService.findMultipleByGivenCounty(countyId);
    }

    /**
     *
     * @param townId
     * @return
     */
    @ApiOperation(value = "get address by given townId")
    @ApiImplicitParam(name = "townId",value = "townId",dataType = "Long", paramType="path")
    @GetMapping(path = "/town/{townId}")
    public  List<Address> getMultipleByTown(
            @PathVariable(value = "townId",name = "townId") Long townId) {
        return  addressService.findMultipleByGivenTown(townId);
    }

    /**
     *
     * @param streetId
     * @return
     */
    @ApiOperation(value = "get address by given streetId")
    @ApiImplicitParam(name = "streetId",value = "streetId",dataType = "Long", paramType="path")
    @GetMapping(path = "/street/{streetId}")
    public List<Address> getMultipleByStreet(
            @PathVariable(value = "streetId",name = "streetId") Long streetId) {
        return  addressService.findMultipleByGivenStreet(streetId);
    }

    /**
     *
     * @param longitude
     * @return
     */
    @ApiOperation(value = "get address by given longitude")
    @ApiImplicitParam(name = "longitude",value = "longitude",dataType = "String", paramType="path")
    @GetMapping(path = "/longitude/{longitude}")
    public List<Address> getMultipleByLongitude(
            @PathVariable(value = "longitude",name = "longitude") String longitude) {
        return  addressService.findMultipleByGivenLongitude(longitude);
    }

    /**
     *
     * @param latitude
     * @return
     */
    @ApiOperation(value = "get address by given latitude")
    @ApiImplicitParam(name = "latitude",value = "latitude",dataType = "String", paramType="path")
    @GetMapping(path = "/latitude/{latitude}")
    public List<Address> getMultipleByLatitude(
            @PathVariable(name = "latitude",value = "latitude") String latitude) {
        return  addressService.findMultipleByGivenLatitude(latitude);
    }

    /**
     *
     * @param latitude
     * @param longitude
     * @return
     */
    @ApiOperation(value = "get address by given latitude")
    @ApiImplicitParams(value ={
            @ApiImplicitParam(name = "latitude",value = "latitude",dataType = "String", paramType="path"),
            @ApiImplicitParam(name = "longitude",value = "longitude",dataType = "String", paramType="path")})
    @GetMapping(path = "/latitude/longitude/{latitude}/{longitude}")
    public Address getOneByLongitudeAndLatitude(
            @PathVariable(name = "latitude",value = "latitude",required = true) String latitude,
            @PathVariable(name = "longitude",value = "longitude",required = true) String longitude) {
        return addressService.findOneByGivenLatitudeAndLongitude(latitude,longitude);
    }

    /**
     *
     * @param desc
     * @return
     */
    @ApiOperation(value = "get address by given descInfo")
    @ApiImplicitParam(name = "desc",value = "desc",dataType = "String", paramType="path")
    @GetMapping(path = "/desc/{desc}")
    public List<Address> getMultipleByDescLike(
            @PathVariable(name = "desc",value = "desc") String desc) {
        return  addressService.findMultipleByGiveDesc(desc);
    }

    /**
     *
     * @param partition
     * @return
     */
    @ApiOperation(value = "get address by given partition")
    @ApiImplicitParam(name = "partition",value = "partition",dataType = "String", paramType="path")
    @GetMapping(path = "/partition/{partition}")
    public List<Address> getMultipleByPartionLike(
            @PathVariable(name = "partition",value = "partition") String partition) {
        return  addressService.findMultipleByGivenPartition(partition);
    }
}
