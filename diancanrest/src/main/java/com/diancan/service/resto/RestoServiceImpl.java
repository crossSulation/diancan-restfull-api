package com.diancan.service.resto;

import com.diancan.domain.restoinfo.RestoBasicInfo;
import com.diancan.domain.restoinfo.RestoBasicInfoRepository;
import com.diancan.service.resto.RestoService;
import org.springframework.beans.factory.annotation.Autowired;

public class RestoServiceImpl implements RestoService {

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
