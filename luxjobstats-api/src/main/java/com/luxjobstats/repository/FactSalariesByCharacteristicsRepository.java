package com.luxjobstats.repository;

import com.luxjobstats.model.FactSalariesByCharacteristics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FactSalariesByCharacteristicsRepository
        extends JpaRepository<FactSalariesByCharacteristics, Long> {

        @Query(
        value = """
                SELECT 
                f.reference_date,
                g.gender_en AS gender,
                SUM(f.employee_count) AS total_employees
                FROM fact_salaries_by_characteristics f
                JOIN dim_gender g ON f.gender_id = g.id
                GROUP BY f.reference_date, g.gender_en
                ORDER BY f.reference_date, g.gender_en;
        """,
        nativeQuery = true
        )
        List<Object[]> getEmployeesByGenderOverTime();

}
