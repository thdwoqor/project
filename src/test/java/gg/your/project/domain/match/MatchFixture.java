package gg.your.project.domain.match;

import gg.your.project.domain.MatchCategory;
import gg.your.project.domain.TeamCategory;
import java.time.LocalDateTime;
import java.util.List;

public class MatchFixture {

    public static Match 매치1() {
        return new Match(
                "KR_7295591783",
                new MatchDetail(
                        "KR_7295591783",
                        1638,
                        LocalDateTime.now(),
                        MatchCategory.SOLO,
                        List.of(
                                new Team(32,0,0,0,0,0,0,4, TeamCategory.BLUE,true),
                                new Team(16,0,0,0,0,0,0,2, TeamCategory.RED,false)

                        ),
                        List.of()
                )
        );
    }
}
