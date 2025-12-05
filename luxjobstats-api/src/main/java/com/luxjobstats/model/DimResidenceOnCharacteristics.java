package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_residence_on_characteristics")
@Data
public class DimResidenceOnCharacteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "residence_fr")
    private String residenceFr;

    @Column(name = "residence_en")
    private String residenceEn;
}
