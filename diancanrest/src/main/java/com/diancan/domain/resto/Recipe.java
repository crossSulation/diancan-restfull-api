package com.diancan.domain.resto;

import javax.persistence.*;

// 菜色
@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String name; //菜名
    private Integer price; //单价
    private Integer rank; // 受欢迎度

    @ManyToOne
    private DialingTable dialingTableRecipe;

    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DialingTable getDialingTableRecipe() {
        return dialingTableRecipe;
    }

    public void setDialingTableRecipe(DialingTable dialingTableRecipe) {
        this.dialingTableRecipe = dialingTableRecipe;
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
