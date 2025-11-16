package com.luxjobstats.repository;

import com.luxjobstats.model.FactSalariesByNationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactSalariesByNationalityRepository
        extends JpaRepository<FactSalariesByNationality, Long> {
}
