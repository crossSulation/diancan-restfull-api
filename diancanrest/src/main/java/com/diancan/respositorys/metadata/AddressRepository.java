package com.diancan.respositorys.metadata;

import com.diancan.domain.resto.metadata.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long>{

    Address findAddressById(Long id);

    List<Address> findAddressesByCityId(Long id);

    List<Address> findAddressesByProvinceId(Long id);

    List<Address> findAddressesByCountyId(Long id);

    List<Address> findAddressesByTownId(Long id);

    List<Address> findAddressesByStreetId(Long id);

    List<Address> findAddressesByLatitude(String latitude);

    List<Address> findAddressesByLongitude(String longitude);

    List<Address> findAddressesByDescContains(String desc);

    List<Address> findAddressesByPartitionLike(String partition);

    Address findAddressByLatitudeAndLongitude(String latitude,String longitude);

}
