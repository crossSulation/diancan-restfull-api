package com.diancan.domain.resto.metadata;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="town")
@Access(AccessType.FIELD)
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="town_id")
    private  Long id;
    private String name;
    private String nameCN;

    @Column(nullable = false,length = 10)
    private String code;

    private String nameEN;

    private Set<Street> streets;

    @ManyToOne()
    @JoinColumn(name="county_town_id")
    private County county;

    private Set<Address> addresses;

    private String desc;
    private String descCN;
    private String descEN;

    public Town() {
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @OneToMany(mappedBy = "town",cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinTable(name="address_town",joinColumns = {@JoinColumn(name="town_id")},inverseJoinColumns = {@JoinColumn(name="address_id")})
    public Set<Address> getAddresses() {
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

    @OneToMany(mappedBy = "town",cascade = CascadeType.ALL,targetEntity = Street.class)
    @JoinTable(name="town_street",joinColumns = {@JoinColumn(name="town_id")},inverseJoinColumns = {@JoinColumn(name="street_id")})
    public Set<Street> getStreets() {
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
