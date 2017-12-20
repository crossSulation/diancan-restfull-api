package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "county")
@Access(AccessType.FIELD)
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "county_id")
    private  Long id;
    @Column(nullable = false,length = 10)
    private String code;
    private String name;
    private String nameCN;
    private String nameEN;
    private String desc;
    private String descCN;
    private String descEN;

    private Set<Town> towns;

    @ManyToOne()
    @JoinColumn(name = "city_county_id")
    private City city;

    private Set<Address> addresses;

    public County() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @OneToMany(mappedBy = "county",cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinTable(name="address_county",joinColumns = {@JoinColumn(name="county_id")},inverseJoinColumns = {@JoinColumn(name="address_id")})
    public Set<Address> getAddresses() {
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

    @OneToMany(mappedBy = "county",cascade = CascadeType.ALL,targetEntity = Town.class)
    @JoinTable(name="county_town",joinColumns = {@JoinColumn(name="county_id")},inverseJoinColumns = {@JoinColumn(name="town_id")})
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
