package com.diancan.respositorys;

import com.diancan.domain.resto.RestTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestTableRepository extends JpaRepository<RestTable,Long> {
}
