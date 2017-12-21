package com.diancan.service.resto;

import com.diancan.domain.resto.DialingTable;
import com.diancan.respositorys.DialingTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DialingTableServiceImpl implements  DialingTableService {

    @Autowired
    DialingTableRepository dialingTableRepository;

    @Override
    public DialingTable findOneById(Long id) {
        return dialingTableRepository.findOne(id);
    }

    @Override
    public DialingTable findOneByNum(Integer num) {
        return dialingTableRepository.findDialingTableByNum(num);
    }

    @Override
    public List<DialingTable> findMultipleByGivenRestaurantId(Long restaurantId) {
        return dialingTableRepository.findDialingTablesByRestaurant_Id(restaurantId);
    }

    @Override
    public List<DialingTable> findMultipleByIsBooked(Boolean isBooked) {
        return dialingTableRepository.findDialingTablesByIsBooked(isBooked);
    }

    @Override
    public List<DialingTable> findMultipleByBookedTime(Integer bookedTime) {
        return dialingTableRepository.findDialingTablesByBookedTimeGreaterThanEqual(bookedTime);
    }

    @Override
    public List<DialingTable> findMultipleByGivenStartBookedTime(Date startBookTime) {
        return dialingTableRepository.findDialingTablesByStartBookTimeGreaterThanEqual(startBookTime);
    }

    public  List<DialingTable> findAll() {
        return  dialingTableRepository.findAll();
    }
}
