package com.diancan.domain.resto;

import com.diancan.domain.resto.constants.DrinkTeste;
import com.diancan.domain.resto.DrinkCategory;
import javax.persistence.*;

//饮料
@Entity
@Table(name="drink")
public class Drink  {
    @Id
    @GeneratedValue
    private Long id;

    private String name; //名称
    private Integer price; //单价
    private Integer rank; // 受欢迎度
    private String dinkImageId;// 饮料图片id
    private DrinkTeste drinkTeste; // 口味

    @ManyToOne
    private DrinkCategory drinkCategory;

    private String vendor; //生产商

    @Column(name="descInfo")
    private String desc; //描述

    @ManyToOne
    private DialingTable dialingTableDrink;

    public Drink() {
    }


    public String getDinkImageId() {
        return dinkImageId;
    }

    public void setDinkImageId(String dinkImageId) {
        this.dinkImageId = dinkImageId;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DialingTable getDialingTableDrink() {
        return dialingTableDrink;
    }

    public void setDialingTableDrink(DialingTable dialingTableDrink) {
        this.dialingTableDrink = dialingTableDrink;
    }

    public DrinkTeste getDrinkTeste() {
        return drinkTeste;
    }

    public void setDrinkTeste(DrinkTeste drinkTeste) {
        this.drinkTeste = drinkTeste;
    }

    public DrinkCategory getDrinkCategory() {
        return drinkCategory;
    }

    public void setDrinkCategory(DrinkCategory drinkCategory) {
        this.drinkCategory = drinkCategory;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
