package com.luxjobstats.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxjobstats.model.Nationality;
import com.luxjobstats.service.NationalityService;

@RestController
@RequestMapping("/api/nationalities")
public class NationalityController {

    private final NationalityService nationalityService;

    public NationalityController(NationalityService nationalityService){
        this.nationalityService = nationalityService;
    }

    @GetMapping
    public List<Nationality> getAll(){
        return nationalityService.getAllNationalities();
    }

    
}
