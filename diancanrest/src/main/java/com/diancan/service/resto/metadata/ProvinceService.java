package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.Province;

import java.util.List;

public interface ProvinceService {

    Province findOneByGivenId(Long id);

    List<Province>  findMultipleByGivenName(String name);

    List<Province> findMultipleByGivenDesc(String desc);

    List<Province> findMultipleByGivenCode(String code);
}
