package com.luxjobstats.service;

import com.luxjobstats.model.DimSector;
import com.luxjobstats.repository.DimSectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimSectorService {

    private final DimSectorRepository sectorRepository;

    public DimSectorService(DimSectorRepository sectorRepository){
        this.sectorRepository = sectorRepository;
    }

    public List<DimSector> getAll(){
        return sectorRepository.findAll();
    }
}
