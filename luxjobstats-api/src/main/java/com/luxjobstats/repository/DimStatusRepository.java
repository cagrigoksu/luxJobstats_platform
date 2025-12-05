package com.luxjobstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxjobstats.model.DimStatus;

public interface DimStatusRepository extends JpaRepository<DimStatus, Long>{
    
}
