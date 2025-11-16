package com.luxjobstats.repository;

import com.luxjobstats.model.FactSalariesByCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactSalariesByCharacteristicsRepository
        extends JpaRepository<FactSalariesByCharacteristics, Long> {
}
