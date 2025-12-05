package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_status")
@Data
public class DimStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_fr")
    private String statusFr;

    @Column(name = "status_en")
    private String statusEn;
}
