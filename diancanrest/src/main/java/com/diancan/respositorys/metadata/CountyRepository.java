package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountyRepository extends JpaRepository<County,Long> {

    County findOneByCity(Long id);

    List<County> findCountiesByCity(City city);

    List<County> findCountiesByNameLike(String name);

    List<County> findCountiesByCodeLike(String code);

    List<County> findCountiesByDescLike(String desc);
}
