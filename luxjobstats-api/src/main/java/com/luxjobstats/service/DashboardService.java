package com.luxjobstats.service;

import com.luxjobstats.dto.CountByLabelDTO;
import com.luxjobstats.dto.MonthPointDTO;
import com.luxjobstats.dto.YearSummaryDTO;
import com.luxjobstats.repository.FactDataByCharacteristicsRepository;
import com.luxjobstats.repository.FactDataByNationalityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final FactDataByNationalityRepository natRepo;
    private final FactDataByCharacteristicsRepository charRepo;

    public DashboardService(FactDataByNationalityRepository natRepo,
                            FactDataByCharacteristicsRepository charRepo) {
        this.natRepo = natRepo;
        this.charRepo = charRepo;
    }

    // years for tabs
    public List<Integer> getYearsDesc() {
        return natRepo.getYearsDesc();
    }

    // one year summary
    public YearSummaryDTO getYearSummary(int year) {
        Long total = natRepo.getTotalEmployeesForYear(year);

        var byGender = mapLabelCount(charRepo.getByGenderForYear(year));
        var byNationality = mapLabelCount(natRepo.getByNationalityForYear(year));
        var bySector = mapLabelCount(natRepo.getBySectorForYear(year));
        var monthly = mapMonthTrend(natRepo.getMonthlyTrendForYear(year));
        var sectorRanking = bySector; // already sorted desc
        var byAge = mapLabelCount(charRepo.getByAgeForYear(year));
        var byStatus = mapLabelCount(charRepo.getByStatusForYear(year));
        var byResidence = mapLabelCount(charRepo.getByResidenceCharForYear(year));

        return new YearSummaryDTO(
                year, total, byGender, byNationality, bySector,
                monthly, sectorRanking, byAge, byStatus, byResidence
        );
    }

    // total (all years)
    public YearSummaryDTO getTotalSummary() {
        Long total = natRepo.getTotalEmployeesAllYears();

        var byGender = mapLabelCount(charRepo.getByGenderAllYears());
        var byNationality = mapLabelCount(natRepo.getByNationalityAllYears());
        var bySector = mapLabelCount(natRepo.getBySectorAllYears());
        var monthly = mapMonthTrend(natRepo.getMonthlyTrendAllYears());
        var sectorRanking = bySector;
        var byAge = mapLabelCount(charRepo.getByAgeAllYears());
        var byStatus = mapLabelCount(charRepo.getByStatusAllYears());
        var byResidence = mapLabelCount(charRepo.getByResidenceCharAllYears());

        return new YearSummaryDTO(
                null, total, byGender, byNationality, bySector,
                monthly, sectorRanking, byAge, byStatus, byResidence
        );
    }

    // helpers
    private List<CountByLabelDTO> mapLabelCount(List<Object[]> rows) {
        var list = new ArrayList<CountByLabelDTO>();
        for (Object[] r : rows) {
            String label = (String) r[0];
            Long cnt = ((Number) r[1]).longValue();
            list.add(new CountByLabelDTO(label, cnt));
        }
        return list;
    }

    private List<MonthPointDTO> mapMonthTrend(List<Object[]> rows) {
        var list = new ArrayList<MonthPointDTO>();
        for (Object[] r : rows) {
            LocalDate month = ((java.sql.Date) r[0]).toLocalDate();
            Long cnt = ((Number) r[1]).longValue();
            list.add(new MonthPointDTO(month, cnt));
        }
        return list;
    }

    // standalone 
    public List<CountByLabelDTO> getGenderForYear(int year) { return mapLabelCount(charRepo.getByGenderForYear(year)); }
    public List<CountByLabelDTO> getSectorForYear(int year) { return mapLabelCount(natRepo.getBySectorForYear(year)); }
    public List<CountByLabelDTO> getNationalityForYear(int year) { return mapLabelCount(natRepo.getByNationalityForYear(year)); }
    public List<MonthPointDTO> getTrendForYear(int year) { return mapMonthTrend(natRepo.getMonthlyTrendForYear(year)); }
}
