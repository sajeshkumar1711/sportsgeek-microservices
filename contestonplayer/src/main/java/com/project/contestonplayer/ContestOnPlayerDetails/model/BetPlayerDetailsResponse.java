package com.project.contestonplayer.ContestOnPlayerDetails.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.queryhelpher.annotations.QueryHelperColumnName;
import com.project.queryhelpher.annotations.QueryHelperPrimaryKey;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "BetOnPlayerDetails Response Model")
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BetPlayerDetailsResponse implements Serializable {

    @QueryHelperColumnName(name = "BetPlayerId")
    @QueryHelperPrimaryKey
    private int betPlayerId;
    private int playerNo;
    private String name;
    private String team;
    private String type;
    private String profilePicture;
    private String userName;
    private String firstName;
    private String lastName;
    private int playerPoints;
}
