package com.luxjobstats.controller;

import com.luxjobstats.model.DimContinent;
import com.luxjobstats.service.DimContinentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    private final DimContinentService service;

    public ContinentController(DimContinentService service) {
        this.service = service;
    }

    @GetMapping
    public List<DimContinent> getAll() {
        return service.getAll();
    }
}
