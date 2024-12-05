package gg.your.project.service;

import gg.your.project.infra.riotgames.MatchClient;
import gg.your.project.service.dto.MatchResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RiotMatchProvider implements MatchProvider {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final MatchClient matchClient;

    @Override
    public List<String> findMatchIds(final String puuid, final int count) {
        return matchClient.getMatchIds(puuid, apiKey, count);
    }

    @Override
    public MatchResponse findMatch(final String matchId) {
        return MatchResponse.from(matchClient.getMatchDetail(matchId, apiKey));
    }
}
