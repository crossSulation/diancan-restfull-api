package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.County;
import com.diancan.respositorys.metadata.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountyServiceImpl implements CountyService {

    @Autowired
    CountyRepository countyRepository;

    @Override
    public County findOneByGivenId(Long id) {
        return countyRepository.findOne(id);
    }

    @Override
    public List<County> findMultipleByGivenCity(City city) {
        return countyRepository.findCountiesByCity(city);
    }

    @Override
    public List<County> findMultipleByGivenName(String name) {
        return countyRepository.findCountiesByNameLike(name);
    }

    @Override
    public List<County> findMultipleByGivenDesc(String desc) {
        return countyRepository.findCountiesByDescLike(desc);
    }

    @Override
    public List<County> findMultipleByGivenCode(String code) {
        return countyRepository.findCountiesByCodeLike(code);
    }
}
