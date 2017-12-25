package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.Street;
import com.diancan.domain.resto.metadata.Town;
import com.diancan.respositorys.metadata.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements  StreetService {

    @Autowired
    StreetRepository streetRepository;

    @Override
    public Street findOneByGivenId(Long id) {
        return streetRepository.findOne(id);
    }

    public List<Street> findAll() {
        return streetRepository.findAll();
    }
    @Override
    public List<Street> findMultipleByGivenName(String name) {
        return streetRepository.findStreetsByNameLike(name);
    }

    @Override
    public List<Street> findMultipleByGivenDesc(String desc) {
        return streetRepository.findStreetsByDescLike(desc);
    }

    @Override
    public List<Street> findMultipleByGivenCode(String code) {
        return streetRepository.findStreetsByCodeLike(code);
    }

    @Override
    public List<Street> findMultipleByGivenTown(Long townId) {
        return streetRepository.findStreetsByTownId(townId);
    }

    public Street addNewOne(Street street) {
        return  streetRepository.save(street);
    }

    public  Street updateOne(Street street) {
        return  streetRepository.save(street);
    }

    public void deleteOneById(Long id) {
        streetRepository.delete(id);
    }

    public  void deleteAll() {
        streetRepository.deleteAll();
    }
}
