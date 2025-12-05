package com.luxjobstats.service;

import com.luxjobstats.model.DimContinent;
import com.luxjobstats.repository.DimContinentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimContinentService {

    private final DimContinentRepository continentRepository;

    public DimContinentService(DimContinentRepository continentRepository){
        this.continentRepository = continentRepository;
    }

    public List<DimContinent> getAll(){
        return continentRepository.findAll();
    }
}
