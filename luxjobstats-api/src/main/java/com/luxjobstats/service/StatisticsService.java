package com.luxjobstats.service;

import com.luxjobstats.repository.FactSalariesByCharacteristicsRepository;
import com.luxjobstats.repository.FactSalariesByNationalityRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final FactSalariesByNationalityRepository factSalariesByNationalityRepository;
    private final FactSalariesByCharacteristicsRepository factSalariesByCharacteristicsRepository;

    public StatisticsService(FactSalariesByNationalityRepository factSalariesByNationalityRepository,
                             FactSalariesByCharacteristicsRepository factSalariesByCharacteristicsRepository) {
        this.factSalariesByNationalityRepository = factSalariesByNationalityRepository;
        this.factSalariesByCharacteristicsRepository = factSalariesByCharacteristicsRepository;
    }

    public Object getOverview() {
        // TODO: implement real overview stats from both fact tables
        return "not implemented yet";
    }

    public Object getSectorStatistics(Long sectorId) {
        // TODO: implement sectorbased stats
        return "not implemented yet";
    }

    public Object getNationalityStatistics(Long nationalityId) {
        // TODO: implement nationality-based stats
        return "not implemented yet";
    }
}
