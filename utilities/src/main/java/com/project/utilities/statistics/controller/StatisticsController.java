package com.project.utilities.statistics.controller;


import com.project.sportsgeeksystemresponse.response.Result;
import com.project.utilities.statistics.exception.StatisticsException;
import com.project.utilities.statistics.model.BetOnTeam;
import com.project.utilities.statistics.model.Statistics;
import com.project.utilities.statistics.service.StatisticsService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(path = "/statistics",produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping(value = "/users/statistics",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = Statistics.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = StatisticsException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<List<Statistics>>> getAllStatistics() {
        Result<List<Statistics>> statList = statisticsService.findAllStatistics();
        return new ResponseEntity<>(statList, HttpStatus.valueOf(statList.getCode()));
    }
    @GetMapping(value = "/users/future-bet",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = Statistics.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = StatisticsException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<List<BetOnTeam>>> getAllFutureBets() {
        Result<List<BetOnTeam>> betList = statisticsService.findFutureBets();
        return new ResponseEntity<>(betList, HttpStatus.valueOf(betList.getCode()));
    }
}
