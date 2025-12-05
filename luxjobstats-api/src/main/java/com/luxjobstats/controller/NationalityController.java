package com.luxjobstats.controller;

import com.luxjobstats.model.DimNationality;
import com.luxjobstats.service.DimNationalityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nationalities")
public class NationalityController {

    private final DimNationalityService service;

    public NationalityController(DimNationalityService service) {
        this.service = service;
    }

    @GetMapping
    public List<DimNationality> getAll() {
        return service.getAll();
    }
}
