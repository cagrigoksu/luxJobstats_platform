package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dim_sector")
@Getter
@Setter
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sector_name_fr")
    private String sectorFr;

    @Column(name = "sector_name_en")
    private String sectorEn;
}
