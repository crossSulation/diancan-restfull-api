package com.diancan.service;

import com.diancan.domain.RestoBasicInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoService {
    void save(RestoBasicInfo restoBasicInfo);
    RestoBasicInfo findRestoById(Integer id);
}
