package com.project.utilities.statistics.service;


import com.project.sportsgeeksystemresponse.response.Result;
import com.project.utilities.statistics.model.BetOnTeam;
import com.project.utilities.statistics.model.Statistics;
import com.project.utilities.statistics.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    @Qualifier("statRepo")
    StatisticsRepository statisticsRepository;

    public Result<List<Statistics>> findAllStatistics() {
        List<Statistics> statList = statisticsRepository.findUserStatistics();
        return new Result<>(200,"Statistics Retrieved Successfully",statList);
    }
    public Result<List<BetOnTeam>> findFutureBets() {
        List<BetOnTeam> betList = statisticsRepository.findFutureBetPoints();
        return new Result<>(200,"Future Bets Retrieved Successfully",betList);
    }
}
