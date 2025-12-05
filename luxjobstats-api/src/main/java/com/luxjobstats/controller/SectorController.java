package com.luxjobstats.controller;

import com.luxjobstats.model.DimSector;
import com.luxjobstats.service.DimSectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final DimSectorService service;

    public SectorController(DimSectorService service) {
        this.service = service;
    }

    @GetMapping
    public List<DimSector> getAll() {
        return service.getAll();
    }
}
