package com.luxjobstats.service;

import com.luxjobstats.model.DimNationality;
import com.luxjobstats.repository.DimNationalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimNationalityService {

    private final DimNationalityRepository nationalityRepository;

    public DimNationalityService(DimNationalityRepository nationalityRepository){
        this.nationalityRepository = nationalityRepository;
    }

    public List<DimNationality> getAll(){
        return nationalityRepository.findAll();
    }
}
