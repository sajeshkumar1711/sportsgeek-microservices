package com.project.matches.mymatches.repository;

import com.project.matches.mymatches.model.MyMatches;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "myMatchesRepo")
public interface MyMatchesRepository {

    public List<MyMatches> findUpcomingContestByUserId(int userId) throws Exception;
    public List<MyMatches> findLiveContestByUserId(int userId) throws Exception;
    public List<MyMatches> findResultContestByUserId(int userId) throws Exception;
}
