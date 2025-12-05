package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "fact_data_by_characteristics")
@Data
public class FactDataByCharacteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_date")
    private LocalDate referenceDate;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private DimGender gender;

    @ManyToOne
    @JoinColumn(name = "residence_id")
    private DimResidenceOnCharacteristics residence;

    @ManyToOne
    @JoinColumn(name = "age_id")
    private DimAge age;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private DimSector sector;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private DimStatus status;

    @Column(name = "number_of_employee")
    private Long numberOfEmployee;
}
