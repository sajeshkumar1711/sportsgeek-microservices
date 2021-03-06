package com.project.players.playertype.mapper;


import com.project.players.playertype.model.PlayerType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerTypeRowMapper implements RowMapper<PlayerType> {
    @Override
    public PlayerType mapRow(ResultSet rs, int rowNum) throws SQLException {
        PlayerType playerType = new PlayerType();
        playerType.setPlayerTypeId(rs.getInt("PlayerTypeId"));
        playerType.setTypeName(rs.getString("TypeName"));
        return playerType;
    }
}
