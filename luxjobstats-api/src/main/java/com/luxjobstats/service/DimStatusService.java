package com.luxjobstats.service;

import com.luxjobstats.model.DimStatus;
import com.luxjobstats.repository.DimStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimStatusService {

    private final DimStatusRepository statusRepository;

    public DimStatusService(DimStatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    public List<DimStatus> getAll(){
        return statusRepository.findAll();
    }
}
