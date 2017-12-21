package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.DialingTable;
import com.diancan.service.resto.DialingTableServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/dialingtables")
public class DialingTableController {

    @Autowired
    DialingTableServiceImpl dialingTableService;

    /**
     *
     * @return
     */
    @ApiOperation(value = "getAllDialingTables")
    @GetMapping(name="getAllDialingTables",value = "getAllDialingTables")
    public List<DialingTable> getAll() {
      return  dialingTableService.findAll();
    }

    /**
     *
     */
    @ApiOperation(value = "getAllDialingTables")
    @DeleteMapping
    public void deleteAll() {
        dialingTableService.deleteAll();
    }

    /**
     *
     * @param id
     */
    @ApiOperation(value = "delete on by given id")
    @ApiImplicitParam(value = "id",name = "id",dataType = "Long",paramType = "path",required = true)
    @DeleteMapping(path = "/{id}")
    public  void deleteOneByGivenId(Long id) {
        dialingTableService.deleteOne(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "get on by given id")
    @ApiImplicitParam(value = "id",name = "id",dataType = "Long",paramType = "path",required = true)
    @GetMapping(path = "/{id}")
    public DialingTable getOneByGivenId(Long id) {
         return  dialingTableService.findOneById(id);
    }

    /**
     *
     * @param newDialingTable
     * @return
     */
    @ApiOperation(value = "update one")
    @ApiImplicitParam(value = "newDialingTable",name = "newDialingTable",dataType = "DialingTable",paramType = "body",required = true)
    @PutMapping
    public DialingTable updateOne(
            @RequestBody(required = true) DialingTable newDialingTable) {
        return  dialingTableService.updateOne(newDialingTable);
    }

    /**
     *
     * @param dialingTable
     * @return
     */
    @ApiOperation(value = "update one")
    @ApiImplicitParam(value = "dialingTable",name = "dialingTable",dataType = "DialingTable",paramType = "body",required = true)
    @PostMapping
    public DialingTable addNewOne(
            @RequestBody(required = true) DialingTable dialingTable) {
        return  dialingTableService.addNewOne(dialingTable);
    }

    /**
     *
     * @param num
     * @return
     */
    @ApiOperation(value = "get on by given num")
    @ApiImplicitParam(value = "num",name = "num",dataType = "Integer",paramType = "path",required = true)
    @GetMapping(path = "/num/{num}")
    public DialingTable getOneByGivenNum(
           @PathVariable(name = "num",value = "num",required = true) Integer num) {
        return  dialingTableService.findOneByNum(num);
    }

    /**
     *
     * @param restaurantId
     * @return
     */
    @ApiOperation(value = "get multiple by given restaurantId")
    @ApiImplicitParam(value = "restaurantId",name = "restaurantId",dataType = "Long",paramType = "path",required = true)
    @GetMapping(path = "/restaurant/{restaurantId}")
    public List<DialingTable> getMultipleByGivenRestaurantId(
            @PathVariable(name = "restaurantId",value = "restaurantId",required = true) Long restaurantId) {
        return  dialingTableService.findMultipleByGivenRestaurantId(restaurantId);
    }

    /**
     *
     * @param isBooked
     * @return
     */
    @ApiOperation(value = "get multiple by given isBooked")
    @ApiImplicitParam(value = "isBooked",name = "isBooked",dataType = "Boolean",paramType = "path",required = true)
    @GetMapping(path = "/booked/{isBooked}")
    public List<DialingTable> getMultipleByGivenIsBooked(
            @PathVariable(name = "isBooked",value = "isBooked",required = true) Boolean isBooked) {
        return  dialingTableService.findMultipleByIsBooked(isBooked);
    }

    /**
     *
     * @param startTime
     * @return
     */
    @ApiOperation(value = "get multiple by given startTime")
    @ApiImplicitParam(value = "startTime",name = "startTime",dataType = "Date",paramType = "path",required = true)
    @GetMapping(path = "/starttime/{starttime}")
    public List<DialingTable> getMultipleByGivenStartTime(
            @PathVariable(name = "starttime",value = "starttime",required = true) Date startTime) {
        return  dialingTableService.findMultipleByGivenStartBookedTime(startTime);
    }

    /**
     *
     * @param bookedTime
     * @return
     */
    @ApiOperation(value = "get multiple by given booked time")
    @ApiImplicitParam(value = "bookedTime",name = "bookedTime",dataType = "Integer",paramType = "path",required = true)
    @GetMapping(path = "/bookedtime/{bookedtime}")
    public List<DialingTable> getMultipleByGivenBookedTime(
            @PathVariable(name = "bookedtime",value = "bookedtime",required = true) Integer bookedTime) {
        return  dialingTableService.findMultipleByBookedTime(bookedTime);
    }
}
