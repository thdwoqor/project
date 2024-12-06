package gg.your.project.service.account;

import feign.FeignException;
import gg.your.project.infra.riotgames.AccountClient;
import gg.your.project.service.account.dto.RiotAccountDto;
import gg.your.project.service.account.dto.RiotIdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RiotAccountProvider {

    @Value("${riotgames.apiKey}")
    private String apiKey;
    private final AccountClient accountClient;

    public RiotAccountDto findAccount(final RiotIdDto dto) {
        try{
            return RiotAccountDto.from(accountClient.getAccount(dto.gameName(), dto.tagline(), apiKey));
        }catch (FeignException e){
            throw new IllegalArgumentException("닉네임을 찾을 수 없습니다.");
        }
    }
}
