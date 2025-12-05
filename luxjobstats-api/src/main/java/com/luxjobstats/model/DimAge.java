package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_age")
@Data
public class DimAge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_label_fr")
    private String ageLabelFr;

    @Column(name = "age_label_en")
    private String ageLabelEn;
}
