package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountClientImpl {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final AccountClient accountClient;

    public AccountResponse getAccount(final String gameName, final String tagLine) {
        return accountClient.getAccount(gameName, tagLine, apiKey);
    }
}
