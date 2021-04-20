package com.project.contestonplayer.ContestOnPlayerDetails.repository;

import com.project.contestonplayer.ContestOnPlayerDetails.model.BetOnPlayerDetails;
import com.project.contestonplayer.ContestOnPlayerDetails.model.BetPlayerDetailsResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "betOnPlayerDetailsRepo")
public interface BetOnPlayerDetailsRepo {

    public List<BetPlayerDetailsResponse> findAllPlayerDetails();
    public List<BetPlayerDetailsResponse> findBetPlayerDetailsByBetPlayerId(int betPlayerId) throws Exception;
    public List<BetPlayerDetailsResponse> findAllBetPlayerDetailsByUserId(int userId) throws Exception;
    public int addBetPlayerDetails(BetOnPlayerDetails betOnPlayerDetails) throws Exception;
    public int updateBetPlayerDetails(int betPlayerId,int playerNo,BetOnPlayerDetails betOnPlayerDetails) throws Exception;
    public int updatePlayerPoints(int betPlayerId,int playerNo,int playerPoints) throws Exception;
    public int deleteBetPlayerDetails(int betPlayerId) throws Exception;
}
