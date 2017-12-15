package com.diancan.domain.resto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//饮料
public class Drink extends Meal {
    @Id
    @GeneratedValue
    private Integer id;
    private DrinkTeste drinkTeste; // 口味
    private DrinkCategory drinkCategory;

    public Drink() {
    }

    private String vendor; //生产商
    private String desc; //描述

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
