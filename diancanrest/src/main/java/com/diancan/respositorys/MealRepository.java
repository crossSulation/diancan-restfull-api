package com.diancan.respositorys;

import com.diancan.domain.resto.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long> {
}
