package gg.your.project.service;

import gg.your.project.service.dto.AccountDto;
import gg.your.project.service.dto.MatchResponse;
import gg.your.project.service.dto.RiotIdDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final AccountProvider accountProvider;
    private final MatchProvider matchProvider;

    public MatchResponse searchLastMatch(final String fullName) {
        AccountDto account = accountProvider.findAccount(RiotIdDto.from(fullName));

        List<String> matchIds = matchProvider.findMatchIds(account.puuid(), 1);

        return matchProvider.findMatch(matchIds.getFirst());
    }
}
