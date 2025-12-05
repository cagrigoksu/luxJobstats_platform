package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "fact_data_by_nationality")
@Data
public class FactDataByNationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_date")
    private LocalDate referenceDate;

    @ManyToOne
    @JoinColumn(name = "residence_id")
    private DimResidenceOnNationality residence;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private DimContinent continent;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private DimNationality nationality;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private DimSector sector;

    @Column(name = "number_of_employee")
    private Long numberOfEmployee;
}
