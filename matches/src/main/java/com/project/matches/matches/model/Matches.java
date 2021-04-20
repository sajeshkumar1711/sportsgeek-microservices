package com.project.matches.matches.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.queryhelpher.annotations.QueryHelperColumnName;
import com.project.queryhelpher.annotations.QueryHelperPrimaryKey;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Matches Model")
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Matches implements Serializable {
    @QueryHelperColumnName(name = "MatchId")
    @QueryHelperPrimaryKey
    private int matchId;
    private int tournamentId;
    private String name;
    private Timestamp startDateTime;
    private int venueId;
    private int team1;
    private int team2;
    private int winnerTeamId;
    private int resultStatus;
    private int minimumBet;
}
