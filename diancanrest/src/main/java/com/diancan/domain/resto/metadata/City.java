package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "city")
@Access(AccessType.FIELD)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private  long id;

    private Set<County> counties;

    @ManyToOne
    @JoinColumn(name = "province_city_id")
    private Province province;

    private Set<Address> addresses;

    @Column()
    private String nameCN;
    @Column()
    private String nameEN;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 10)
    private String zipCode;
    private String desc;
    @Column()
    private String descCN;
    @Column()
    private String descEN;

    public City() {
    }

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinTable(name="address_city",joinColumns = {@JoinColumn(name="city_id")},inverseJoinColumns = {@JoinColumn(name="address_id")})
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,targetEntity = County.class)
    @JoinTable(name="city_county",joinColumns = {@JoinColumn(name="city_id")},inverseJoinColumns = {@JoinColumn(name="county_id")})
    public Set<County> getCounties() {
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
