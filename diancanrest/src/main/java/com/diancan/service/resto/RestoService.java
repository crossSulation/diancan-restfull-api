package com.diancan.service.resto;

import com.diancan.domain.restoinfo.RestoBasicInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoService {
    void save(RestoBasicInfo restoBasicInfo);
    RestoBasicInfo findRestoById(Integer id);
}
