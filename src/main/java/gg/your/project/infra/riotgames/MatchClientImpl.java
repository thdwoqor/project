package gg.your.project.infra.riotgames;

import gg.your.project.service.MatchProvider;
import gg.your.project.service.dto.MatchDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchClientImpl implements MatchProvider {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final MatchClient matchClient;

    @Override
    public List<String> findMatchIds(final String puuid, final int count) {
        return matchClient.getMatchIds(puuid, apiKey, count);
    }

    @Override
    public MatchDto findMatch(final String matchId) {
        return MatchDto.from(matchClient.getMatchDetail(matchId, apiKey));
    }
}
