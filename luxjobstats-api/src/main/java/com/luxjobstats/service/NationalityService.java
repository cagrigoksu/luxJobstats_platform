package com.luxjobstats.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luxjobstats.repository.NationalityRepository;
import com.luxjobstats.model.Nationality;;

@Service
public class NationalityService {

    private final NationalityRepository nationalityRepository;

    public NationalityService(NationalityRepository nationalityRepository){
        this.nationalityRepository = nationalityRepository;
    }

    public List<Nationality> getAllNationalities(){
        return nationalityRepository.findAll();
    }


    
}
