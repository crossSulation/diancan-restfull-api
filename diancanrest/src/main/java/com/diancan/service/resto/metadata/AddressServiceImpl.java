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
    public List<Address> findMultipleByGivenProvince(Province province) {
        return addressRepository.findAddressesByProvince(province);
    }

    @Override
    public List<Address> findMultipleByGivenCity(City city) {
        return addressRepository.findAddressesByCity(city);
    }

    @Override
    public List<Address> findMultipleByGivenTown(Town town) {
        return addressRepository.findAddressesByTown(town);
    }

    @Override
    public List<Address> findMultipleByGivenStreet(Street street) {
        return addressRepository.findAddressesByStreet(street);
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
    public List<Address> findMultipleByGivenCounty(County county) {
        return addressRepository.findAddressesByCounty(county);
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
}
