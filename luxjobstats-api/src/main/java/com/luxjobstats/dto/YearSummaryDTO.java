package com.luxjobstats.dto;

import java.util.List;

public class YearSummaryDTO {
    private Integer year;       // null for total
    private Long totalEmployees;
    private List<CountByLabelDTO> byGender;
    private List<CountByLabelDTO> byNationality;
    private List<CountByLabelDTO> bySector;
    private List<MonthPointDTO> monthlyTrend;
    private List<CountByLabelDTO> sectorRanking;
    private List<CountByLabelDTO> byAge;
    private List<CountByLabelDTO> byStatus;
    private List<CountByLabelDTO> byResidence;

    public YearSummaryDTO(
            Integer year,
            Long totalEmployees,
            List<CountByLabelDTO> byGender,
            List<CountByLabelDTO> byNationality,
            List<CountByLabelDTO> bySector,
            List<MonthPointDTO> monthlyTrend,
            List<CountByLabelDTO> sectorRanking,
            List<CountByLabelDTO> byAge,
            List<CountByLabelDTO> byStatus,
            List<CountByLabelDTO> byResidence
    ) {
        this.year = year;
        this.totalEmployees = totalEmployees;
        this.byGender = byGender;
        this.byNationality = byNationality;
        this.bySector = bySector;
        this.monthlyTrend = monthlyTrend;
        this.sectorRanking = sectorRanking;
        this.byAge = byAge;
        this.byStatus = byStatus;
        this.byResidence = byResidence;
    }

    public Integer getYear() { return year; }
    public Long getTotalEmployees() { return totalEmployees; }
    public List<CountByLabelDTO> getByGender() { return byGender; }
    public List<CountByLabelDTO> getByNationality() { return byNationality; }
    public List<CountByLabelDTO> getBySector() { return bySector; }
    public List<MonthPointDTO> getMonthlyTrend() { return monthlyTrend; }
    public List<CountByLabelDTO> getSectorRanking() { return sectorRanking; }
    public List<CountByLabelDTO> getByAge() { return byAge; }
    public List<CountByLabelDTO> getByStatus() { return byStatus; }
    public List<CountByLabelDTO> getByResidence() { return byResidence; }
}
