package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.Province;

import java.util.List;

public interface CityService {

    City findOneByGivenId(Long id);

    List<City> findMultipleByGivenProvince(Province province);

    List<City> findMultipleByGivenName(String name);

    List<City> findMultipleByGivenDesc(String desc);

    List<City> findMultipleByGivenCode(String code);

}
