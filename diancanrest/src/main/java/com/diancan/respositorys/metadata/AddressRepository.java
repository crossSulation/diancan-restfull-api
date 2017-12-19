package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long>{

    Address findAddressById(Long id);

    List<Address> findAddressesByCity(City city);

    List<Address> findAddressesByProvince(Province province);

    List<Address> findAddressesByCounty(County county);

    List<Address> findAddressesByTown(Town town);

    List<Address> findAddressesByStreet(Street street);

    List<Address> findAddressesByLatitude(String latitude);

    List<Address> findAddressesByLongitude(String longitude);

    List<Address> findAddressByDescContains(String desc);

    List<Address> findAddressesByPartitionLike(String partition);

    Street findAddressByLatitudeAndLongitude(String latitude,String longitude);



}
