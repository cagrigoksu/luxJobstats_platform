package com.luxjobstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxjobstats.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{
    
}
