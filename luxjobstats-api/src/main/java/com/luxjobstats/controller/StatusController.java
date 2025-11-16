package com.luxjobstats.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxjobstats.model.Status;
import com.luxjobstats.service.StatusService;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }
    
    @GetMapping
    public List<Status> getAll(){
        return statusService.getAllStatuses();
    }
}
