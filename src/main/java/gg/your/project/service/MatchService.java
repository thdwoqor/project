package gg.your.project.service;

import gg.your.project.domain.MatchCategory;
import gg.your.project.domain.account.Account;
import gg.your.project.service.dto.MatchResponse;
import gg.your.project.service.match.RiotMatchProvider;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final AccountFacadeService accountFacadeService;
    private final RiotMatchProvider matchProvider;

    public MatchResponse searchLastMatch(final String fullName) {
        Account account = accountFacadeService.findOrSaveAccount(fullName);

        List<String> matchIds = matchProvider.findMatchIds(account.getPuuid(), 10);

        List<CompletableFuture<MatchResponse>> futures = matchIds.stream()
                .map(matchProvider::findMatchAsync)
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .filter(match -> match.matchCategory() == MatchCategory.SOLO ||
                        match.matchCategory() == MatchCategory.TEAM ||
                        match.matchCategory() == MatchCategory.NORMAL
                ).findFirst()
                .orElseThrow();
    }
}
