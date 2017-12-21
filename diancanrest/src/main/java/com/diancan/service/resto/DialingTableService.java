package com.diancan.service.resto;

import com.diancan.domain.resto.DialingTable;

import java.sql.Date;
import java.util.List;

public interface DialingTableService {

    DialingTable findOneById(Long id);

    DialingTable findOneByNum(Integer num);

    List<DialingTable> findMultipleByGivenRestaurantId(Long restaurantId);

    List<DialingTable> findMultipleByIsBooked(Boolean isBooked);

    List<DialingTable> findMultipleByBookedTime(Integer bookedTime);

    List<DialingTable> findMultipleByGivenStartBookedTime(Date startBookTime);
}
