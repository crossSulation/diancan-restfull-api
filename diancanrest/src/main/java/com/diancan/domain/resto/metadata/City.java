package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "city")
@Access(AccessType.FIELD)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,targetEntity = County.class,fetch = FetchType.LAZY)
    private Set<County> counties = new HashSet<County>();

    @OneToOne
    private Province province;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.LAZY)
    private Set<Address> addresses =new HashSet<Address>();

    private String nameCN;

    private String nameEN;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false,length = 10)
    private String zipCode;

    @Column(name="descInfo")
    private String desc;

    private String descCN;

    private String descEN;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Set<Address> getAddresses() {
        for(Address addr: addresses) {
            addr.setId(id);
        }
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<County> getCounties() {
        for(County county : counties) {
            county.setId(id);
        }
        return counties;
    }

    public void setCounties(Set<County> counties) {
        this.counties = counties;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
}
