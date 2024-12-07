package gg.your.project.domain.match;

import gg.your.project.domain.MatchCategory;
import gg.your.project.domain.TeamCategory;
import gg.your.project.service.dto.MatchResponse;
import java.time.LocalDateTime;
import java.util.List;

public class MatchFixture {

    public static Match 매치(final String matchId) {
        return new Match(
                matchId,
                new MatchDetail(
                        matchId,
                        1638,
                        LocalDateTime.now(),
                        MatchCategory.SOLO,
                        List.of(
                                new Team(32, 0, 0, 0, 0, 0, 0, 4, TeamCategory.BLUE, true),
                                new Team(16, 0, 0, 0, 0, 0, 0, 2, TeamCategory.RED, false)

                        ),
                        List.of()
                )
        );
    }

    public static MatchResponse 매치응답(final String matchId) {
        return MatchResponse.from(new Match(
                matchId,
                new MatchDetail(
                        matchId,
                        1638,
                        LocalDateTime.now(),
                        MatchCategory.SOLO,
                        List.of(
                                new Team(32, 0, 0, 0, 0, 0, 0, 4, TeamCategory.BLUE, true),
                                new Team(16, 0, 0, 0, 0, 0, 0, 2, TeamCategory.RED, false)

                        ),
                        List.of()
                )
        ));
    }
}
