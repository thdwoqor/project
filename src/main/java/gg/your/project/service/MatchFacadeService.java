package gg.your.project.service;

import gg.your.project.domain.MatchCategory;
import gg.your.project.domain.account.Account;
import gg.your.project.domain.match.Match;
import gg.your.project.service.dto.MatchResponse;
import gg.your.project.service.match.MatchService;
import gg.your.project.service.match.RiotMatchProvider;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchFacadeService {

    private final AccountFacadeService accountFacadeService;
    private final MatchService matchService;
    private final RiotMatchProvider matchProvider;

    public MatchResponse findLastMatch(final String fullName) {
        Account account = accountFacadeService.findOrSaveAccount(fullName);

        List<Match> matches = findLatestMatches(account, 10);

        return matches.stream()
                .filter(this::isSupportedMatchCategory)
                .findFirst()
                .map(MatchResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("최근 10경기 내 (일반, 솔로 랭크, 자유 랭크) 전적이 존재하지 않습니다."));
    }

    private List<Match> findLatestMatches(final Account account, final int count) {
        List<String> matchIds = matchProvider.findMatchIds(account.getPuuid(), count);
        List<Match> matches = matchService.findAllByMatchIdIn(matchIds);

        if (matchIds.size() == matches.size()) {
            return matches;
        }

        return matchService.saveAll(findNewUpdatedMatch(matches, matchIds));
    }

    private List<Match> findNewUpdatedMatch(final List<Match> matches, final List<String> matchIds) {
        List<String> findMatchIds = matches.stream()
                .map(Match::getMatchId)
                .toList();
        matchIds.removeAll(findMatchIds);

        List<CompletableFuture<MatchResponse>> futures = matchIds.stream()
                .map(matchProvider::findMatchAsync)
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .map(MatchResponse::toMatch)
                .toList();
    }

    private boolean isSupportedMatchCategory(final Match match) {
        return match.getMatchDetail().getMatchCategory() == MatchCategory.SOLO ||
                match.getMatchDetail().getMatchCategory() == MatchCategory.TEAM ||
                match.getMatchDetail().getMatchCategory() == MatchCategory.NORMAL;
    }
}
