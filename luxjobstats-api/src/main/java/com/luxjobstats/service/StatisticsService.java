package com.luxjobstats.service;

import com.luxjobstats.dto.*;
import com.luxjobstats.repository.FactDataByNationalityRepository;
import com.luxjobstats.repository.FactDataByCharacteristicsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class StatisticsService {

    private final FactDataByNationalityRepository natRepo;
    private final FactDataByCharacteristicsRepository charRepo;

    public StatisticsService(
            FactDataByNationalityRepository natRepo,
            FactDataByCharacteristicsRepository charRepo
    ) {
        this.natRepo = natRepo;
        this.charRepo = charRepo;
    }

    public Map<String, Object> getOverview() {

        var totals = new ArrayList<TotalEmployeesByYearDTO>();
        for (Object[] row : natRepo.getTotalEmployeesByYear()) {
            totals.add(new TotalEmployeesByYearDTO(
                    ((Number) row[0]).intValue(),
                    ((Number) row[1]).longValue()
            ));
        }

        var trend = new ArrayList<TrendPointDTO>();
        for (Object[] row : natRepo.getTrendOverTime()) {
            trend.add(new TrendPointDTO(
                    (LocalDate) row[0],
                    ((Number) row[1]).longValue()
            ));
        }

        Map<String, Object> res = new HashMap<>();
        res.put("latest", totals.isEmpty() ? null : totals.get(totals.size() - 1));
        res.put("years", totals);
        res.put("trend", trend);
        return res;
    }

    public Map<String, Object> getSectorStatistics(Long sectorId) {

        var trend = new ArrayList<TrendPointDTO>();
        for (Object[] row : natRepo.getSectorTrend(sectorId)) {
            trend.add(new TrendPointDTO(
                    (LocalDate) row[0],
                    ((Number) row[1]).longValue()
            ));
        }

        var perYear = new ArrayList<TotalEmployeesByYearDTO>();
        for (Object[] row : natRepo.getSectorEmployeesByYear(sectorId)) {
            perYear.add(new TotalEmployeesByYearDTO(
                    ((Number) row[0]).intValue(),
                    ((Number) row[1]).longValue()
            ));
        }

        Map<String, Object> res = new HashMap<>();
        res.put("sectorId", sectorId);
        res.put("trend", trend);
        res.put("perYear", perYear);
        return res;
    }

    public Map<String, Object> getNationalityStatistics(Long nationalityId) {

        var perSector = new ArrayList<EmployeesBySectorDTO>();
        for (Object[] row : natRepo.getEmployeesBySectorForNationality(nationalityId)) {
            perSector.add(new EmployeesBySectorDTO(
                    (String) row[0],
                    ((Number) row[1]).longValue()
            ));
        }

        var trend = new ArrayList<TrendPointDTO>();
        for (Object[] row : natRepo.getNationalityTrend(nationalityId)) {
            trend.add(new TrendPointDTO(
                    (LocalDate) row[0],
                    ((Number) row[1]).longValue()
            ));
        }

        Map<String, Object> res = new HashMap<>();
        res.put("nationalityId", nationalityId);
        res.put("perSector", perSector);
        res.put("trend", trend);
        return res;
    }

    public List<GenderOverTimeDto> getEmployeesByGenderOverTime() {

        var result = new ArrayList<GenderOverTimeDto>();

        for (Object[] row : charRepo.getEmployeesByGenderOverTime()) {
            result.add(new GenderOverTimeDto(
                    (LocalDate) row[0],
                    (String) row[1],
                    ((Number) row[2]).longValue()
            ));
        }

        return result;
    }
}
