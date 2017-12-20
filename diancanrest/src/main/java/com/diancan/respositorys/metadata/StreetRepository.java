package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.Street;
import com.diancan.domain.resto.metadata.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street,Long> {

    Street findOneByStreetId(Long id);

    List<Street> findStreetsByCodeLike(String code);

    List<Street> findStreetsByTownId(Long townId);

    List<Street> findStreetsByNameLike(String name);

    List<Street> findStreetsByDescLike(String desc);
}
