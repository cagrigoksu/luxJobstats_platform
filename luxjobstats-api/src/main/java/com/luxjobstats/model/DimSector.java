package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_sector")
@Data
public class DimSector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sector_fr")
    private String sectorFr;

    @Column(name = "sector_en")
    private String sectorEn;
}
