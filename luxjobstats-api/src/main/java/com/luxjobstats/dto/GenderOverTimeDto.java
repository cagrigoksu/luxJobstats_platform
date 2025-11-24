package com.luxjobstats.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenderOverTimeDto {
    private LocalDate referenceDate;
    private String gender;
    private Long totalEmployees;
}
