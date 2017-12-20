package com.diancan.domain.resto.metadata;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue
    private  long id;
    @OneToMany(mappedBy = "city")
    private List<County> counties;
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

    public List<County> getCounties() {
        return counties;
    }

    public void setCounties(List<County> counties) {
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
