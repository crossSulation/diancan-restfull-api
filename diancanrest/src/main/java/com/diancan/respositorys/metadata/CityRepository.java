package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    City findOneById(Long id);

    List<City> findCitiesByProvinceId(Long provinceId);

    List<City> findCitiesByNameIsLike(String cityName);

    List<City> findCitiesByZipCodeIsLike(String zipcode);

    List<City> findCitiesByDescIsLike(String desc);
}
