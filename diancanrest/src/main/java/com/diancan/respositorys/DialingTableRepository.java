package com.diancan.respositorys;

import com.diancan.domain.resto.DialingTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface DialingTableRepository extends JpaRepository<DialingTable,Long> {

    DialingTable findOne(Long id);

    DialingTable findDialingTableByNum(Integer num);

    List<DialingTable> findDialingTablesByIsBooked(Boolean isBooked);

    List<DialingTable> findDialingTablesByBookedTimeGreaterThanEqual(Integer bookedTime);

    List<DialingTable> findDialingTablesByStartBookTimeGreaterThanEqual(Date startBookedTime);

    List<DialingTable> findDialingTablesByRestaurant_Id(Long restaurantId);

}
