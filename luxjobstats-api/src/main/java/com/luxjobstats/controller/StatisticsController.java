package com.luxjobstats.controller;

import com.luxjobstats.dto.GenderOverTimeDto;
import com.luxjobstats.service.StatisticsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService service;

    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping("/overview")
    public Map<String, Object> overview() {
        return service.getOverview();
    }

    @GetMapping("/sector/{sectorId}")
    public Map<String, Object> sector(@PathVariable Long sectorId) {
        return service.getSectorStatistics(sectorId);
    }

    @GetMapping("/nationality/{nationalityId}")
    public Map<String, Object> nationality(@PathVariable Long nationalityId) {
        return service.getNationalityStatistics(nationalityId);
    }

    @GetMapping("/gender")
    public List<GenderOverTimeDto> genderOverTime() {
        return service.getEmployeesByGenderOverTime();
    }
}
