package com.luxjobstats.service;

import com.luxjobstats.model.DimResidenceOnNationality;
import com.luxjobstats.repository.DimResidenceOnNationalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimResidenceOnNationalityService {

    private final DimResidenceOnNationalityRepository repo;

    public DimResidenceOnNationalityService(DimResidenceOnNationalityRepository repo){
        this.repo = repo;
    }

    public List<DimResidenceOnNationality> getAll(){
        return repo.findAll();
    }
}
