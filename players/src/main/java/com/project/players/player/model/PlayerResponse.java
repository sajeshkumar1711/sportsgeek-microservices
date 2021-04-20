package com.project.players.player.model;

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
@ApiModel(description = "Player Model")
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerResponse implements Serializable {
    @QueryHelperColumnName(name = "PlayerId")
    @QueryHelperPrimaryKey
    private int playerId;
    private String team;
    private String name;
    private String playerType;
    private String profilePicture;
    private Double Credits;
}
