package com.project.players.playertype.controller;


import com.project.players.playertype.exception.PlayerTypeException;
import com.project.players.playertype.model.PlayerType;
import com.project.players.playertype.service.PlayerTypeService;
import com.project.sportsgeeksystemresponse.response.Result;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "/player-types", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerTypeController {

    @Autowired
    PlayerTypeService playerTypeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = PlayerType.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = PlayerTypeException.class),
                    @ApiResponse(code = 403, message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<List<PlayerType>>> getAllPlayerType() {
        Result<List<PlayerType>> playerTypeList = playerTypeService.findAllPlayerType();
        return new ResponseEntity<>(playerTypeList, HttpStatus.valueOf(playerTypeList.getCode()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = PlayerType.class),
                    @ApiResponse(code = 404, message = "Bad request", response = PlayerTypeException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = PlayerTypeException.class),
                    @ApiResponse(code = 403, message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<PlayerType>> getPlayerTypeById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int id) throws Exception {
        Result<PlayerType> playerTypeList = playerTypeService.findPlayerTypeById(id);
        return new ResponseEntity<>(playerTypeList, HttpStatus.valueOf(playerTypeList.getCode()));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 201, message = "success", response = PlayerType.class),
                    @ApiResponse(code = 400, message = "Bad request", response = PlayerTypeException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = PlayerTypeException.class),
                    @ApiResponse(code = 403, message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<PlayerType>> addPlayerType(@RequestBody(required = true) @Valid PlayerType PlayerType) throws Exception {
        Result<PlayerType> playerTypeResult = playerTypeService.addPlayerType(PlayerType);
        return new ResponseEntity(playerTypeResult, HttpStatus.valueOf(playerTypeResult.getCode()));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 201, message = "success", response = PlayerType.class),
                    @ApiResponse(code = 400, message = "Bad request", response = PlayerTypeException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = PlayerTypeException.class),
                    @ApiResponse(code = 403, message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<PlayerType>> updatePlayerType(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int id, @RequestBody(required = true) @Valid PlayerType PlayerType) throws Exception {
        Result<PlayerType> playerTypeResult = playerTypeService.updatePlayerType(id, PlayerType);
        return new ResponseEntity(playerTypeResult, HttpStatus.valueOf(playerTypeResult.getCode()));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = PlayerType.class),
                    @ApiResponse(code = 404, message = "Bad request", response = PlayerTypeException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = PlayerTypeException.class),
                    @ApiResponse(code = 403, message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<PlayerType>> deletePlayerTypeById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int id) throws Exception {
        Result<Integer> integerResult = playerTypeService.deletePlayerType(id);
        return new ResponseEntity(integerResult, HttpStatus.valueOf(integerResult.getCode()));
    }
}
