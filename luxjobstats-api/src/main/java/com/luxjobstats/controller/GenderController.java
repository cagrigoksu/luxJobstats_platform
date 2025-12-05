package com.luxjobstats.controller;

import com.luxjobstats.model.DimGender;
import com.luxjobstats.service.DimGenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class GenderController {

    private final DimGenderService service;

    public GenderController(DimGenderService service) {
        this.service = service;
    }

    @GetMapping
    public List<DimGender> getAll() {
        return service.getAll();
    }
}
