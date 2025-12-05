package com.luxjobstats.controller;

import com.luxjobstats.model.DimResidenceOnNationality;
import com.luxjobstats.model.DimResidenceOnCharacteristics;
import com.luxjobstats.service.DimResidenceOnNationalityService;
import com.luxjobstats.service.DimResidenceOnCharacteristicsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residences")
public class ResidenceController {

    private final DimResidenceOnNationalityService natService;
    private final DimResidenceOnCharacteristicsService charService;

    public ResidenceController(
            DimResidenceOnNationalityService natService,
            DimResidenceOnCharacteristicsService charService
    ) {
        this.natService = natService;
        this.charService = charService;
    }

    @GetMapping("/nationality")
    public List<DimResidenceOnNationality> getNationalityResidences() {
        return natService.getAll();
    }

    @GetMapping("/characteristics")
    public List<DimResidenceOnCharacteristics> getCharacteristicsResidences() {
        return charService.getAll();
    }
}
