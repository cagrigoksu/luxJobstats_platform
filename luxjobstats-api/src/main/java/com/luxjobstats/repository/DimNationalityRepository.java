package com.luxjobstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxjobstats.model.DimNationality;

public interface DimNationalityRepository extends JpaRepository <DimNationality, Long> {
    
}
