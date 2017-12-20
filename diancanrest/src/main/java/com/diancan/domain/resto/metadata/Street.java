package com.diancan.domain.resto.metadata;

import javax.persistence.*;

@Entity
public class Street {
    @Id
    @GeneratedValue
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

    public Street() {
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
