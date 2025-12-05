package com.luxjobstats.service;

import com.luxjobstats.model.DimGender;
import com.luxjobstats.repository.DimGenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimGenderService {

    private final DimGenderRepository genderRepository;

    public DimGenderService(DimGenderRepository genderRepository){
        this.genderRepository = genderRepository;
    }

    public List<DimGender> getAll(){
        return genderRepository.findAll();
    }
}
