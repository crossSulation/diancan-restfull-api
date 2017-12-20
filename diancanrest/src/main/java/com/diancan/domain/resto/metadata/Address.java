package com.diancan.domain.resto.metadata;

import com.diancan.domain.resto.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

/**
 * defined address entity
 */
@Entity
@Table(name = "address")
@Access(AccessType.FIELD)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long addressId; // 主键

    @OneToOne(mappedBy = "address")
    private Restaurant restaurant;//

    private Long provinceId;

    private Long cityId;

    private Long countyId;

    private Long townId;

    private Long streetId;

    private String partition;

    private String longitude; //经度

    private String latitude;// 纬度

    private String desc;

    private String descCN;

    private String descEN;

    public Address() {
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescCN() {
        return descCN;
    }

    public void setDescCN(String descCN) {
        this.descCN = descCN;
    }

    public String getDescEN() {
        return descEN;
    }

    public void setDescEN(String descEN) {
        this.descEN = descEN;
    }

    private String descEN() {
        return this.descCN;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
