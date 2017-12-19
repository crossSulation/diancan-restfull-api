package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.County;
import com.diancan.domain.resto.metadata.Town;

import java.util.List;

public interface TownService {

    Town findOneByGivenId(Long id);

    List<Town> findMultipleByGivenCounty(County county);

    List<Town> findMultipleByGivenName(String name);

    List<Town> findMultipleByGivenCode(String code);

    List<Town> findMultipleByGivenDesc(String desc);


}
