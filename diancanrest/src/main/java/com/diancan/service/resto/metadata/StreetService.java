package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.Street;
import com.diancan.domain.resto.metadata.Town;

import java.util.List;

public interface StreetService {

    Street findOneByGivenId(Long id);

    List<Street> findMultipleByGivenName(String name);

    List<Street> findMultipleByGivenDesc(String desc);

    List<Street> findMultipleByGivenCode(String code);

    List<Street>  findMultipleByGivenTown(Town town);
}
