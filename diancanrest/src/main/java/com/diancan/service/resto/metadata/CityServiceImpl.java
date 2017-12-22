package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.Province;
import com.diancan.respositorys.metadata.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements  CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City findOneByGivenId(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public List<City> findMultipleByGivenProvince(Long provinceId) {
        return cityRepository.findCitiesByProvinceId(provinceId);
    }

    @Override
    public List<City> findMultipleByGivenName(String name) {
        return cityRepository.findCitiesByNameIsLike(name);
    }

    @Override
    public List<City> findMultipleByGivenDesc(String desc) {
        return cityRepository.findCitiesByDescIsLike(desc);
    }

    @Override
    public List<City> findMultipleByGivenCode(String code) {
        return cityRepository.findCitiesByZipCodeIsLike(code);
    }

    public City addNewOne(City city) {
        return  cityRepository.save(city);
    }

    public  City updateOne(City city) {
        return  cityRepository.save(city);
    }

    public  void deleteOne(Long id) {
        cityRepository.delete(id);
    }

    public void deleteAll() {
        cityRepository.deleteAll();
    }
}
