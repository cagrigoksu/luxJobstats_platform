package com.luxjobstats.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luxjobstats.model.Status;
import com.luxjobstats.repository.StatusRepository;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatuses(){
        return statusRepository.findAll();
    }
    
}
