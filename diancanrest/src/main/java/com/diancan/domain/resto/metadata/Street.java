package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "street")
@Access(AccessType.FIELD)
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="street_id")
    private  Long id;

    @Column(nullable = false,length = 50)
    private String name;
    private String nameCN;
    private String nameEN;
    private String desc;
    private String descCN;
    private String descEN;
    @Column(nullable = false,length = 10)
    private String code;

    @ManyToOne
    @JoinColumn(name = "town_street_id")
    private Town town;

    private Set<Address> addresses;
    public Street() {
    }

    @OneToMany(mappedBy = "street",cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinTable(name="address_street",joinColumns = {@JoinColumn(name="street_id")},inverseJoinColumns = {@JoinColumn(name="address_id")})
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
