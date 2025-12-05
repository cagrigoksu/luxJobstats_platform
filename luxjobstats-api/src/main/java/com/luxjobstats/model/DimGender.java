package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dim_gender")
@Data
public class DimGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender_fr")
    private String genderFr;

    @Column(name = "gender_en")
    private String genderEn;
}
