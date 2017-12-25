package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.Province;
import com.diancan.respositorys.metadata.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements  ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Province findOneByGivenId(Long id) {
        return provinceRepository.findOne(id);
    }

    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
    @Override
    public List<Province> findMultipleByGivenName(String name) {
        return provinceRepository.findProvincesByNameLike(name);
    }

    @Override
    public List<Province> findMultipleByGivenDesc(String desc) {
        return provinceRepository.findProvincesByDescLike(desc);
    }

    @Override
    public List<Province> findMultipleByGivenCode(String code) {
        return provinceRepository.findProvincesByCodeLike(code);
    }

    public Province addNewOne(Province province) {
        return provinceRepository.save(province);
    }

    public Province updateOne(Province province) {
        return  provinceRepository.save(province);
    }

    public void deleteOneById(Long id) {
        provinceRepository.delete(id);
    }

    public void deleteAll() {
        provinceRepository.deleteAll();
    }
}
