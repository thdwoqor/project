package gg.your.project.service;

import gg.your.project.service.dto.MatchDto;
import java.util.List;

public interface MatchProvider {

    List<String> findMatchIds(final String name,final int count);
    MatchDto findMatch(final String matchId);
}
