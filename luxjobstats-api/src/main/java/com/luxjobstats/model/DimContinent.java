package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_continent")
@Data
public class DimContinent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "continent_fr")
    private String continentFr;

    @Column(name = "continent_en")
    private String continentEn;
}
