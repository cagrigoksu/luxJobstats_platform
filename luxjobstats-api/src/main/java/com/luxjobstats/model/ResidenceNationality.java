package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dim_residence_nationality")
@Getter
@Setter
public class ResidenceNationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "label_fr")
    private String residenceNationalityFr;

    @Column(name = "label_en")
    private String residenceNationalityEn;
}
