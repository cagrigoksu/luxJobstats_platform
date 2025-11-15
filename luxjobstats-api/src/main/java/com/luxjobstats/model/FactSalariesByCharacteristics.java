package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "fact_salaries_by_characteristics")
@Getter
@Setter
public class FactSalariesByCharacteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reference_date")
    private LocalDate referenceDate;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender genderId;

    @ManyToOne
    @JoinColumn(name = "residence_nationality_id")
    private ResidenceNationality residenceNationalityId;

    @ManyToOne
    @JoinColumn(name = "age_id")
    private Age ageId;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sectorId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

    @Column(name = "employee_count")
    private Integer employeeCount;
}
