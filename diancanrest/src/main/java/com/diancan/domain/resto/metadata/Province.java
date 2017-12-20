package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "province")
@Access(AccessType.FIELD)
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Long id;
    @Column(nullable = false,length = 10)
    private String  code;

    private Set<City> cities;

    private Set<Address> addresses;

    private String name;
    private String nameCN;
    private String nameEN;
    private String desc;
    private String descCN;
    private String descEN;

    public Province() {
    }

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinTable(name="address_province",joinColumns = {@JoinColumn(name="province_id")},inverseJoinColumns = {@JoinColumn(name="address_id")})
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

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL,targetEntity = City.class)
    @JoinTable(name="province_city",joinColumns = {@JoinColumn(name="province_id")},inverseJoinColumns = {@JoinColumn(name="city_id")})
    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
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
}
