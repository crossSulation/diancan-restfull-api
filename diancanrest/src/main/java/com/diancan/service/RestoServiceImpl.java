package com.diancan.service;

import com.diancan.domain.RestoBasicInfo;
import com.diancan.domain.RestoBasicInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RestoServiceImpl implements RestoService{

    @Autowired
    private RestoBasicInfoRepository restoBasicInfoRepository;
    @Override
    public void save(RestoBasicInfo restoBasicInfo) {
         restoBasicInfoRepository.save(restoBasicInfo);
    }

    @Override
    public RestoBasicInfo findRestoById(Integer id) {
         return restoBasicInfoRepository.findOne(id);
    }
}
