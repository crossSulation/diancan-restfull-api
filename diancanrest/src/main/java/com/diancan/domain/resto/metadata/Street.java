package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "street")
@Access(AccessType.FIELD)
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long streetId;

    @Column(nullable = false,length = 50)
    private String name;

    private String nameCN;

    private String nameEN;

    private String desc;

    private String descCN;

    private String descEN;

    @Column(nullable = false,length = 10)
    private String code;

    private Long townId;

    @OneToMany(mappedBy = "streetId",cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.LAZY)
    private Set<Address> addresses =new HashSet<>();

    public Street() {
    }

    public Set<Address> getAddresses() {
        for(Address addr : addresses) {
            addr.setStreetId(streetId);
        }
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
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
