package com.luxjobstats.controller;

import com.luxjobstats.model.DimStatus;
import com.luxjobstats.service.DimStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    private final DimStatusService service;

    public StatusController(DimStatusService service) {
        this.service = service;
    }

    @GetMapping
    public List<DimStatus> getAll() {
        return service.getAll();
    }
}
