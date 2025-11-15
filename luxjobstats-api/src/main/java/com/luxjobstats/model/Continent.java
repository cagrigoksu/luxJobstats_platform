package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dim_continent")
@Getter
@Setter
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "continent_name_fr")
    private String continentFr;

    @Column(name = "continent_name_en")
    private String continentEn;
}
