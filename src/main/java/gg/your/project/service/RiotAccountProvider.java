package gg.your.project.service;

import gg.your.project.infra.riotgames.AccountClient;
import gg.your.project.service.dto.AccountDto;
import gg.your.project.service.dto.RiotIdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RiotAccountProvider implements AccountProvider {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final AccountClient accountClient;

    @Override
    public AccountDto findAccount(final RiotIdDto dto) {
        return AccountDto.from(accountClient.getAccount(dto.gameName(), dto.tagline(), apiKey));
    }
}
