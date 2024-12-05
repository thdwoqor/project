package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.dto.MatchDetailResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchClientImpl {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final MatchClient matchClient;

    public List<String> getMatchIds(final String puuid, final int count) {
        return matchClient.getMatchIds(puuid, apiKey, count);
    }

    public MatchDetailResponse getMatchDetail(final String matchId) {
        return matchClient.getMatchDetail(matchId, apiKey);
    }
}
