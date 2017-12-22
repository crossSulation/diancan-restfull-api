package com.diancan.service.resto.metadata;


import com.diancan.domain.resto.metadata.*;
import com.diancan.respositorys.metadata.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address findOneByGivenId(Long id) {
        return addressRepository.findOne(id);
    }

    @Override
    public List<Address> findMultipleByGivenProvince(Long provinceId) {
        return addressRepository.findAddressesByProvinceId(provinceId);
    }

    @Override
    public List<Address> findMultipleByGivenCity(Long cityId) {
        return addressRepository.findAddressesByCityId(cityId);
    }

    @Override
    public List<Address> findMultipleByGivenTown(Long townId) {
        return addressRepository.findAddressesByTownId(townId);
    }

    @Override
    public List<Address> findMultipleByGivenStreet(Long streetId) {
        return addressRepository.findAddressesByStreetId(streetId);
    }

    @Override
    public List<Address> findMultipleByGivenLongitude(String longitude) {
        return addressRepository.findAddressesByLongitude(longitude);
    }

    @Override
    public List<Address> findMultipleByGivenLatitude(String latitude) {
        return addressRepository.findAddressesByLatitude(latitude);
    }

    @Override
    public List<Address> findMultipleByGivenCounty(Long countyId) {
        return addressRepository.findAddressesByCountyId(countyId);
    }

    @Override
    public List<Address> findMultipleByGivenPartition(String partition) {
        return addressRepository.findAddressesByPartitionLike(partition);
    }

    @Override
    public Address findOneByGivenLatitudeAndLongitude(String latitude, String longitude) {
        return addressRepository.findAddressByLatitudeAndLongitude(latitude,longitude);
    }

    @Override
    public List<Address> findMultipleByGiveDesc(String desc) {
        return addressRepository.findAddressesByDescContains(desc);
    }

    public  List<Address> findAll() {
        return  addressRepository.findAll();
    }

    public  Address addNewOne(Address address) {
        return  addressRepository.save(address);
    }

    public void deleteOneById(Long id) {
         addressRepository.delete(id);
    }

    public  Address updateOne(Address address) {
       return   addressRepository.save(address);
    }

}
