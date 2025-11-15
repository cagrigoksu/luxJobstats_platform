package com.luxjobstats.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dim_gender")
@Getter
@Setter
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gender_fr")
    private String genderFr;

    @Column(name = "gender_en")
    private String genderEn;
}
