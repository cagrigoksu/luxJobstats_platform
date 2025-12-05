package com.luxjobstats.repository;

import com.luxjobstats.model.FactDataByNationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactDataByNationalityRepository extends JpaRepository<FactDataByNationality, Long> {

    // total employees per year
    @Query("""
        select extract(YEAR from f.referenceDate),
               sum(f.numberOfEmployee)
        from FactDataByNationality f
        group by extract(YEAR from f.referenceDate)
        order by extract(YEAR from f.referenceDate)
    """)
    List<Object[]> getTotalEmployeesByYear();

    // global trend (date/total emp)
    @Query("""
        select f.referenceDate, sum(f.numberOfEmployee)
        from FactDataByNationality f
        group by f.referenceDate
        order by f.referenceDate
    """)
    List<Object[]> getTrendOverTime();

    // sector trend
    @Query("""
        select f.referenceDate, sum(f.numberOfEmployee)
        from FactDataByNationality f
        where f.sector.id = :sectorId
        group by f.referenceDate
        order by f.referenceDate
    """)
    List<Object[]> getSectorTrend(Long sectorId);

    // sector employees per year
    @Query("""
        select extract(YEAR from f.referenceDate),
               sum(f.numberOfEmployee)
        from FactDataByNationality f
        where f.sector.id = :sectorId
        group by extract(YEAR from f.referenceDate)
        order by extract(YEAR from f.referenceDate)
    """)
    List<Object[]> getSectorEmployeesByYear(Long sectorId);

    // employees by sector for given nationality
    @Query("""
        select f.sector.sectorEn,
               sum(f.numberOfEmployee)
        from FactDataByNationality f
        where f.nationality.id = :nationalityId
        group by f.sector.sectorEn
        order by sum(f.numberOfEmployee) desc
    """)
    List<Object[]> getEmployeesBySectorForNationality(Long nationalityId);

    // nationality trend
    @Query("""
        select f.referenceDate,
               sum(f.numberOfEmployee)
        from FactDataByNationality f
        where f.nationality.id = :nationalityId
        group by f.referenceDate
        order by f.referenceDate
    """)
    List<Object[]> getNationalityTrend(Long nationalityId);
}
