package com.diancan.service.resto.metadata;

import com.diancan.domain.resto.metadata.*;

import java.util.List;

public interface AddressService {

    Address  findOneByGivenId(Long id);

    List<Address> findMultipleByGivenProvince(Long provinceId);

    List<Address> findMultipleByGivenCity(Long cityId);

    List<Address> findMultipleByGivenTown(Long townId);

    List<Address> findMultipleByGivenStreet(Long streetId);

    List<Address> findMultipleByGivenLongitude(String longitude);

    List<Address> findMultipleByGivenLatitude(String latitude);

    List<Address> findMultipleByGivenPartition(String partition);

    List<Address> findMultipleByGiveDesc(String desc);

    Address findOneByGivenLatitudeAndLongitude(String latitude,String longitude);

    List<Address> findMultipleByGivenCounty(Long countyId);
}
