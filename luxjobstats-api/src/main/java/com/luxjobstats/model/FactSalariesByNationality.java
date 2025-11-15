package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "fact_salaries_by_nationality")
@Getter
@Setter
public class FactSalariesByNationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reference_date")
    private LocalDate referenceDate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryId;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continentId;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationalityId;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sectorId;

    @Column(name = "employee_count")
    private Integer employeeCount;
}
