package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.City;
import com.diancan.domain.resto.metadata.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountyRepository extends JpaRepository<County,Long> {

    County findOneById(Long id);

    List<County> findCountiesByCityId(Long cityId);

    List<County> findCountiesByNameLike(String name);

    List<County> findCountiesByCodeLike(String code);

    List<County> findCountiesByDescLike(String desc);
}
