package com.diancan.respositorys;

import com.diancan.domain.resto.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink,Long> {
}
