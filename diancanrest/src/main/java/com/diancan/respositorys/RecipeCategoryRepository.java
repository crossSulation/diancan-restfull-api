package com.diancan.respositorys;


import com.diancan.domain.resto.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory,Long> {

    RecipeCategory findRecipeCategoryById(Long id);

    @Query("select dc from DrinkCategory dc")
    RecipeCategory listAllCategory();

    RecipeCategory findDrinkCategoryByCodeIs(String code);

    @Query("select rc from RecipeCategory rc where rc.name like %:name% or rc.nameCn like %:nameCN% or rc.nameEn like %:nameEN%")
    List<RecipeCategory> findRecipeCategoriesByNameMatch(@Param("name") String name, @Param("nameCN") String nameCN, @Param("nameEN") String nameEN);

    @Query("select rc from RecipeCategory rc where rc.description like %:descinfo% or rc.descCn like %:descCN% or rc.descEn like %:descEN%")
    List<RecipeCategory> findRecipeCategoriesByDescriptionMatche(@Param("descinfo") String descinfo,@Param("descCN") String descCN,@Param("descEN") String descEN);

    void deleteRecipeCategoryByCode(String code);

    @Query("delete from RecipeCategory rc where rc.name like %:name% or rc.nameEn like %:nameEn% or rc.nameCn like %:nameCN%")
    void deleteRecipeCategoriesByNameMatche(@Param("name") String name,@Param("nameEn") String nameEn,@Param("nameCN") String nameCN);

    @Query("delete from RecipeCategory rc where rc.description like %:description% or rc.descCn like %:descCN% or rc.descEn like %:descEN%")
    void deleteRecipeCategoriesByDescriptionMatche(@Param("description") String description,@Param("descCN") String descCN,@Param("descEN") String descEN);
}
