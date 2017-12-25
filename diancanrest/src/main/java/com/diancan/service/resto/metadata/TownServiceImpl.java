package com.diancan.service.resto.metadata;


import com.diancan.domain.resto.metadata.Town;
import com.diancan.respositorys.metadata.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    TownRepository townRepository;

    @Override
    public Town findOneByGivenId(Long id) {
        return townRepository.findOne(id);
    }

    public  List<Town> findAll() {
        return townRepository.findAll();
    }
    @Override
    public List<Town> findMultipleByGivenCounty(Long countyId) {
        return townRepository.findTownsByCountyId(countyId);
    }

    @Override
    public List<Town> findMultipleByGivenName(String name) {
        return townRepository.findTownsByNameLike(name);
    }

    @Override
    public List<Town> findMultipleByGivenCode(String code) {
        return townRepository.findTownsByCodeLike(code);
    }

    @Override
    public List<Town> findMultipleByGivenDesc(String desc) {
        return townRepository.findTownsByDescLike(desc);
    }

    public Town addNewOne(Town town) {
       return townRepository.save(town);
    }

    public Town updateOne(Town town) {
        return  townRepository.save(town);
    }

    public  void  deleteAll() {
        townRepository.deleteAll();
    }

    public void deleteOneById(Long id) {
        townRepository.delete(id);
    }
}
