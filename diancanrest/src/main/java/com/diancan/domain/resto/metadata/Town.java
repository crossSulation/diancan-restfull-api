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
    private  Long id;

    @Column(nullable = false,unique = true)
    private String name;

    private String nameCN;

    @Column(nullable = false,length = 10)
    private String code;

    private String nameEN;

    @OneToMany(mappedBy = "town",cascade = CascadeType.ALL,targetEntity = Street.class,fetch = FetchType.LAZY)
    private Set<Street> streets = new HashSet<Street>();

    @OneToOne
    private County county;

    @OneToMany(mappedBy = "town",cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.LAZY)
    private Set<Address> addresses =new HashSet<Address>();

    @Column(name="descInfo")
    private String desc;

    private String descCN;

    private String descEN;

    public Town() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Set<Address> getAddresses() {
        for(Address addr : addresses) {
            addr.setId(id);
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
            street.setId(id);
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
