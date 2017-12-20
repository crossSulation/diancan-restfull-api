package com.diancan.domain.resto.metadata;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="town")
@Access(AccessType.FIELD)
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long townId;

    @Column(nullable = false,unique = true)
    private String name;

    private String nameCN;

    @Column(nullable = false,length = 10)
    private String code;

    private String nameEN;

    @OneToMany(mappedBy = "townId",cascade = CascadeType.ALL,targetEntity = Street.class,fetch = FetchType.LAZY)
    private Set<Street> streets = new HashSet<>();

    private Long countyId;

    @OneToMany(mappedBy = "townId",cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.LAZY)
    private Set<Address> addresses =new HashSet<>();

    private String desc;

    private String descCN;

    private String descEN;

    public Town() {
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Set<Address> getAddresses() {
        for(Address addr : addresses) {
            addr.setTownId(townId);
        }
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public Set<Street> getStreets() {
        for(Street street:streets) {
            street.setTownId(townId);
        }
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
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
