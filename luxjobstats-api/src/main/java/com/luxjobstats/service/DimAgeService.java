package com.luxjobstats.service;

import com.luxjobstats.model.DimAge;
import com.luxjobstats.repository.DimAgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimAgeService {

    private final DimAgeRepository ageRepository;

    public DimAgeService(DimAgeRepository ageRepository){
        this.ageRepository = ageRepository;
    }

    public List<DimAge> getAll(){
        return ageRepository.findAll();
    }
}
