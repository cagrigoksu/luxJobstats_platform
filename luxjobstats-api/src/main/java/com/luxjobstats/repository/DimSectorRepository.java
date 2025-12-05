package com.luxjobstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxjobstats.model.DimSector;

public interface DimSectorRepository extends JpaRepository<DimSector, Long> {
    
}
