package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.County;

import java.util.List;

public interface CountyService {

    County findOneByGivenId(Long id);

    List<County> findMultipleByGivenCity(City city);

    List<County> findMultipleByGivenName(String name);

    List<County> findMultipleByGivenDesc(String desc);

    List<County> findMultipleByGivenCode(String code);
}
