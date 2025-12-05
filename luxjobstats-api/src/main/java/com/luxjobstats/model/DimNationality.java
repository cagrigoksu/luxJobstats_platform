package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_nationality")
@Data
public class DimNationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nationality_fr")
    private String nationalityFr;

    @Column(name = "nationality_en")
    private String nationalityEn;
}
