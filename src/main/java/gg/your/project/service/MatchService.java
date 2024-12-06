package gg.your.project.service;

import gg.your.project.domain.account.Account;
import gg.your.project.service.dto.MatchResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final AccountFacadeService accountFacadeService;
    private final MatchProvider matchProvider;

    public MatchResponse searchLastMatch(final String fullName) {
        Account account = accountFacadeService.findOrSaveAccount(fullName);

        List<String> matchIds = matchProvider.findMatchIds(account.getPuuid(), 1);

        return matchProvider.findMatch(matchIds.getFirst());
    }
}
