package com.project.utilities.statistics.repository;

import com.project.utilities.statistics.model.BetOnTeam;
import com.project.utilities.statistics.model.Statistics;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "statRepo")
public interface StatisticsRepository {

    public List<Statistics> findUserStatistics();
    public List<BetOnTeam> findFutureBetPoints();
}
