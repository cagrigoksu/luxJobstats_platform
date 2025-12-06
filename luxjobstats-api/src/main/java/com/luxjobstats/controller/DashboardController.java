package com.luxjobstats.controller;

import com.luxjobstats.dto.CountByLabelDTO;
import com.luxjobstats.dto.MonthPointDTO;
import com.luxjobstats.dto.YearSummaryDTO;
import com.luxjobstats.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class DashboardController {

    private final DashboardService svc;

    public DashboardController(DashboardService svc) {
        this.svc = svc;
    }

    // years for tabs
    @GetMapping("/years")
    public List<Integer> years() {
        return svc.getYearsDesc();
    }

    // year summary 
    @GetMapping("/year/{year}")
    public YearSummaryDTO year(@PathVariable int year) {
        return svc.getYearSummary(year);
    }

    // total summary (all years)
    @GetMapping("/total")
    public YearSummaryDTO total() {
        return svc.getTotalSummary();
    }

    // standalone epoints
    @GetMapping("/year/{year}/gender")
    public List<CountByLabelDTO> gender(@PathVariable int year) {
        return svc.getGenderForYear(year);
    }

    @GetMapping("/year/{year}/sector")
    public List<CountByLabelDTO> sector(@PathVariable int year) {
        return svc.getSectorForYear(year);
    }

    @GetMapping("/year/{year}/nationality")
    public List<CountByLabelDTO> nationality(@PathVariable int year) {
        return svc.getNationalityForYear(year);
    }

    @GetMapping("/year/{year}/trend")
    public List<MonthPointDTO> trend(@PathVariable int year) {
        return svc.getTrendForYear(year);
    }
}
