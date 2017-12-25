package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.County;
import com.diancan.respositorys.metadata.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyServiceImpl implements CountyService {

    @Autowired
    CountyRepository countyRepository;

    @Override
    public County findOneByGivenId(Long id) {
        return countyRepository.findOne(id);
    }

    public List<County> findAll() {
        return countyRepository.findAll();
    }
    @Override
    public List<County> findMultipleByGivenCity(Long cityId) {
        return countyRepository.findCountiesByCityId(cityId);
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

    public County addNewOne(County county) {
        return  countyRepository.save(county);
    }

    public  County updateOne(County county) {
        return  countyRepository.save(county);
    }

    public  void deleteOne(Long id) {
        countyRepository.delete(id);
    }

    public void deleteAll() {
        countyRepository.deleteAll();
    }
}
