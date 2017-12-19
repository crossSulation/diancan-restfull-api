package com.diancan.domain.resto.metadata;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

/**
 * defined address entity
 */
@Entity
public class Address {
    @Id
    @GeneratedValue
    private  Long id; // 主键
    @OneToOne
    private  Province province;//
    @OneToOne
    private City city; //市
    @OneToOne
    private County county;//县
    @OneToOne
    private Town town; //镇
    @OneToOne
    private Street street;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }
}
