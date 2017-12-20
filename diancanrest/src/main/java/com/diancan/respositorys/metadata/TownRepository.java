package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.County;
import com.diancan.domain.resto.metadata.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TownRepository extends JpaRepository<Town,Long> {

    Town findOneByTownId(Long id);

    List<Town> findTownsByCodeLike(String code);

    List<Town> findTownsByCountyId(Long countyId);

    List<Town> findTownsByNameLike(String name);

    List<Town> findTownsByDescLike(String desc);
}
