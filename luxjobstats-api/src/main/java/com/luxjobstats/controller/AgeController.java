package com.luxjobstats.controller;

import com.luxjobstats.model.DimAge;
import com.luxjobstats.service.DimAgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ages")
public class AgeController {

    private final DimAgeService service;

    public AgeController(DimAgeService service) {
        this.service = service;
    }

    @GetMapping
    public List<DimAge> getAll() {
        return service.getAll();
    }
}
