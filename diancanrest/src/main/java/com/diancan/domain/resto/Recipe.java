package com.diancan.domain.resto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 菜色
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String name; //菜名
    private Integer price; //单价
    private Integer rank; // 受欢迎度

    public Recipe() {
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
}
