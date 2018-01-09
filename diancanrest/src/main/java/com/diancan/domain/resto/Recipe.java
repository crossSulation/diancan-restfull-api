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
    private String RecipleImageId;// 菜品图片
    @ManyToOne
    private DialingTable dialingTableRecipe;

    @ManyToOne
    private RecipeCategory recipeCategory;

    public Recipe() {
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getRecipleImageId() {
        return RecipleImageId;
    }

    public void setRecipleImageId(String recipleImageId) {
        RecipleImageId = recipleImageId;
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
