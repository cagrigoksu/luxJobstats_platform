package com.luxjobstats.repository;

import com.luxjobstats.model.FactDataByCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactDataByCharacteristicsRepository extends JpaRepository<FactDataByCharacteristics, Long> {

    @Query("""
        select f.referenceDate,
               f.gender.genderEn,
               sum(f.numberOfEmployee)
        from FactDataByCharacteristics f
        group by f.referenceDate, f.gender.genderEn
        order by f.referenceDate, f.gender.genderEn
    """)
    List<Object[]> getEmployeesByGenderOverTime();
}
