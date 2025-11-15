package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dim_age")
@Getter
@Setter
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "age_label_fr")
    private String ageFr;

    @Column(name = "age_label_en")
    private String ageEn;
}
