package com.luxjobstats.dto;

import java.time.LocalDate;

public class MonthPointDTO {
    private LocalDate month;
    private Long employees;

    public MonthPointDTO(LocalDate month, Long employees) {
        this.month = month;
        this.employees = employees;
    }

    public LocalDate getMonth() { return month; }
    public Long getEmployees() { return employees; }
}
