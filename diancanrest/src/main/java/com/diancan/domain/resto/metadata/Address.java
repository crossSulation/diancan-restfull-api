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
    private  Long id; // 主键

    @OneToOne
    private Restaurant restaurant;//

    @OneToOne
    private Province province;

    @OneToOne
    private City city;

    @OneToOne
    private County county;

    @OneToOne
    private Town town;

    @OneToOne
    private Street street;

    @Column(name="partitionInfo")
    private String partition;

    private String longitude; //经度

    private String latitude;// 纬度

    @Column(name="descInfo")
    private String desc;

    private String descCN;

    private String descEN;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
