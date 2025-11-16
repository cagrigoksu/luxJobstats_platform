package com.luxjobstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxjobstats.model.Nationality;

public interface NationalityRepository extends JpaRepository <Nationality, Long> {
    
}
