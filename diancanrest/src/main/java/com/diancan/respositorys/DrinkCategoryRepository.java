package com.diancan.respositorys;

import com.diancan.domain.resto.DrinkCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrinkCategoryRepository  extends JpaRepository<DrinkCategory,Long>{

    DrinkCategory findDrinkCategoryById(Long id);

    @Query("select dc from DrinkCategory dc")
    DrinkCategory listAllCategory();

    DrinkCategory findDrinkCategoryByCodeIs(String code);

    @Query("select dc from DrinkCategory dc where dc.name like %:name% or dc.nameCN like %:nameCN% or dc.nameEn like %:nameEN%")
    List<DrinkCategory> findDrinkCategoriesByNameMatch(@Param("name") String name,@Param("nameCN") String nameCN,@Param("nameEN") String nameEN);

    @Query("select dc from DrinkCategory dc where dc.description like %:descinfo% or dc.descCN like %:descCN% or dc.descEN like %:descEN%")
    List<DrinkCategory> findDrinkCategoriesByDescriptionMatch(@Param("descinfo") String descinfo,@Param("descCN") String descCN,@Param("descEN") String descEN);

    void deleteDrinkCategoryByCode(String code);

    @Query("delete from DrinkCategory dc where dc.name like %:name% or dc.nameEn like %:nameEn% or dc.nameCN like %:nameCN%")
    void deleteDrinkCategoriesByNameMatche(@Param("name") String name,@Param("nameEn") String nameEn,@Param("nameCN") String nameCN);

    @Query("delete from DrinkCategory dc where dc.description like %:description% or dc.descCN like %:descCN% or dc.descEN like %:descEN%")
    void deleteDrinkCategoriesByDescriptionMatche(@Param("description") String description,@Param("descCN") String descCN,@Param("descEN") String descEN);


}
