package com.project.matches.mymatches.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.queryhelpher.annotations.QueryHelperColumnName;
import com.project.queryhelpher.annotations.QueryHelperPrimaryKey;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "MyMatches Model")
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyMatches implements Serializable {

    @QueryHelperColumnName(name = "MatchId")
    @QueryHelperPrimaryKey
    private int MatchId;
    @NotNull
    private String TeamName;
    @NotNull
    private int BetPoints;
    @NotNull
    private String Team1Short;
    private String Team1Logo;
    private String Team2Short;
    private String Team2Logo;
    @NotNull
    private String Venue;
    private Timestamp StartDatetime;
    private String WinnerTeamName;
    private int WinningPoints;
}
