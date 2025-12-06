package com.luxjobstats.repository;

import com.luxjobstats.model.FactDataByNationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactDataByNationalityRepository extends JpaRepository<FactDataByNationality, Long> {

    // ---- years for tabs (desc)
    @Query(value = """
        select distinct extract(year from reference_date)::int as y
        from fact_data_by_nationality
        order by y desc
    """, nativeQuery = true)
    List<Integer> getYearsDesc();

    // ---- totals by year (used for trend across years)
    @Query(value = """
        select extract(year from reference_date)::int as y,
               sum(number_of_employee) as cnt
        from fact_data_by_nationality
        group by y
        order by y
    """, nativeQuery = true)
    List<Object[]> getTotalEmployeesByYear();

    // ---- total employees for a given year
    @Query(value = """
        select coalesce(sum(number_of_employee), 0)
        from fact_data_by_nationality
        where extract(year from reference_date) = :year
    """, nativeQuery = true)
    Long getTotalEmployeesForYear(int year);

    // ---- employees by nationality for a given year
    @Query(value = """
        select n.nationality_en as label, sum(f.number_of_employee) as cnt
        from fact_data_by_nationality f
        join dim_nationality n on n.id = f.nationality_id
        where extract(year from f.reference_date) = :year
        group by n.nationality_en
        order by cnt desc
    """, nativeQuery = true)
    List<Object[]> getByNationalityForYear(int year);

    // ---- employees by sector for a given year
    @Query(value = """
        select s.sector_en as label, sum(f.number_of_employee) as cnt
        from fact_data_by_nationality f
        join dim_sector s on s.id = f.sector_id
        where extract(year from f.reference_date) = :year
        group by s.sector_en
        order by cnt desc
    """, nativeQuery = true)
    List<Object[]> getBySectorForYear(int year);

    // ---- monthly trend within a given year
    @Query(value = """
        select date_trunc('month', reference_date)::date as m,
               sum(number_of_employee) as cnt
        from fact_data_by_nationality
        where extract(year from reference_date) = :year
        group by m
        order by m
    """, nativeQuery = true)
    List<Object[]> getMonthlyTrendForYear(int year);

    // ---- all-years aggregates (for "Total" tab)
    @Query(value = """
        select coalesce(sum(number_of_employee), 0)
        from fact_data_by_nationality
    """, nativeQuery = true)
    Long getTotalEmployeesAllYears();

    @Query(value = """
        select n.nationality_en as label, sum(f.number_of_employee) as cnt
        from fact_data_by_nationality f
        join dim_nationality n on n.id = f.nationality_id
        group by n.nationality_en
        order by cnt desc
    """, nativeQuery = true)
    List<Object[]> getByNationalityAllYears();

    @Query(value = """
        select s.sector_en as label, sum(f.number_of_employee) as cnt
        from fact_data_by_nationality f
        join dim_sector s on s.id = f.sector_id
        group by s.sector_en
        order by cnt desc
    """, nativeQuery = true)
    List<Object[]> getBySectorAllYears();

    @Query(value = """
        select date_trunc('month', reference_date)::date as m,
               sum(number_of_employee) as cnt
        from fact_data_by_nationality
        group by m
        order by m
    """, nativeQuery = true)
    List<Object[]> getMonthlyTrendAllYears();

    // ---- (optional/legacy) keep if used elsewhere; safe to remove later if unused

    // global daily trend
    @Query("""
        select f.referenceDate, sum(f.numberOfEmployee)
        from FactDataByNationality f
        group by f.referenceDate
        order by f.referenceDate
    """)
    List<Object[]> getTrendOverTime();

    // sector trend over time
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

    // employees by sector for a nationality (used in earlier endpoints)
    @Query("""
        select f.sector.sectorEn,
               sum(f.numberOfEmployee)
        from FactDataByNationality f
        where f.nationality.id = :nationalityId
        group by f.sector.sectorEn
        order by sum(f.numberOfEmployee) desc
    """)
    List<Object[]> getEmployeesBySectorForNationality(Long nationalityId);

    // nationality trend over time
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
