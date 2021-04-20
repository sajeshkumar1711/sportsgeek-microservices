package com.project.players.playertype.repository;

import com.project.players.playertype.model.PlayerType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "playerTypeRepo")
public interface PlayerTypeRepository {
    public List<PlayerType> findAllPlayerType();

    public List<PlayerType> findPlayerTypeById(int i) throws Exception;

    public int addPlayerType(PlayerType PlayerType) throws Exception;

    public boolean updatePlayerType(int id, PlayerType PlayerType) throws Exception;

    public int deletePlayerType(int id) throws Exception;
}
