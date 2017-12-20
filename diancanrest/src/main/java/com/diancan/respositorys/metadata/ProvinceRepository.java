package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province,Long>{

    Province findOneByProvinceId(Long id);

    List<Province> findProvincesByNameLike(String name);

    List<Province> findProvincesByDescLike(String desc);

    List<Province> findProvincesByCodeLike(String code);
}
