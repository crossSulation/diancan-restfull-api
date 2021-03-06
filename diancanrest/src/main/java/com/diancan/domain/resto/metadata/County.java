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
    private  Long id;

    @Column(nullable = false,length = 10)
    private String code;

    private String name;

    private String nameCN;

    private String nameEN;

    @Column(name="descInfo")
    private String desc;

    private String descCN;

    private String descEN;

    @OneToMany(mappedBy = "county",cascade = CascadeType.ALL,targetEntity = Town.class,fetch = FetchType.LAZY)
    private Set<Town> towns =new HashSet<Town>();

    @OneToOne
    private City city;

    @ManyToOne
    private Address address;

    public County() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
            town.setId(id);
        }
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
