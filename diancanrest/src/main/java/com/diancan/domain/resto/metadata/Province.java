package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "province")
@Access(AccessType.FIELD)
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 10)
    private String  code;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL,targetEntity = City.class,fetch = FetchType.LAZY)
    private Set<City> cities =new HashSet<City>();

    @ManyToOne
    private Address address;

    @Column(nullable = false,length = 50,unique = true)
    private String name;

    @Column(unique = true)
    private String nameCN;

    @Column(unique = true)
    private String nameEN;

    @Column(name="descInfo")
    private String desc;

    private String descCN;

    private String descEN;

    public Province() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<City> getCities() {
        for(City city : cities) {
            city.setId(id);
        }
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
