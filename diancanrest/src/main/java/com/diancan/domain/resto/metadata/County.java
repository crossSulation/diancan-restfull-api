package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "county")
@Access(AccessType.FIELD)
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long countyId;

    @Column(nullable = false,length = 10)
    private String code;

    private String name;

    private String nameCN;

    private String nameEN;

    private String desc;

    private String descCN;

    private String descEN;

    @OneToMany(mappedBy = "countyId",cascade = CascadeType.ALL,targetEntity = Town.class,fetch = FetchType.LAZY)
    private Set<Town> towns =new HashSet<>();

    private Long cityId;

    @OneToMany(mappedBy = "countyId",cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();

    public County() {
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Set<Address> getAddresses() {
        for(Address addr : addresses) {
            addr.setCountyId(countyId);
        }
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
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

    public Set<Town> getTowns() {
        for(Town town : towns) {
            town.setCountyId(countyId);
        }
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
