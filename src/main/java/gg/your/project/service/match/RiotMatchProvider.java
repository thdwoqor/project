package gg.your.project.service.match;

import gg.your.project.infra.riotgames.MatchClient;
import gg.your.project.service.dto.MatchResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RiotMatchProvider {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final MatchClient matchClient;

    public List<String> findMatchIds(final String puuid, final int count) {
        return matchClient.getMatchIds(puuid, apiKey, count);
    }

    public MatchResponse findMatch(final String matchId) {
        return MatchResponse.from(matchClient.getMatchDetail(matchId, apiKey));
    }

    @Async
    public CompletableFuture<MatchResponse> findMatchAsync(final String matchId) {
        return CompletableFuture.completedFuture(MatchResponse.from(matchClient.getMatchDetail(matchId, apiKey)));
    }
}
