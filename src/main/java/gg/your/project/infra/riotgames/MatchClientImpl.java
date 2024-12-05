package gg.your.project.infra.riotgames;

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
}
