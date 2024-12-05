package gg.your.project.service;

import gg.your.project.service.dto.MatchResponse;
import java.util.List;

public interface MatchProvider {

    List<String> findMatchIds(final String puuid,final int count);
    MatchResponse findMatch(final String matchId);
}
