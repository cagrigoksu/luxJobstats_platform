package com.luxjobstats.service;

import com.luxjobstats.model.DimResidenceOnCharacteristics;
import com.luxjobstats.repository.DimResidenceOnCharacteristicsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimResidenceOnCharacteristicsService {

    private final DimResidenceOnCharacteristicsRepository repo;

    public DimResidenceOnCharacteristicsService(DimResidenceOnCharacteristicsRepository repo){
        this.repo = repo;
    }

    public List<DimResidenceOnCharacteristics> getAll(){
        return repo.findAll();
    }
}
