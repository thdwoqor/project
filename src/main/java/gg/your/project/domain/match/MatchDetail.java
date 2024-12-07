package gg.your.project.domain.match;

import gg.your.project.domain.MatchCategory;
import jakarta.persistence.Convert;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchDetail {

    private String matchId;
    private long gameTime;
    private LocalDateTime gameDate;
    private MatchCategory matchCategory;
    private List<Team> teams;
    private List<Player> players;

    public MatchDetail(final String matchId, final long gameTime, final LocalDateTime gameDate,
                       final MatchCategory matchCategory, final List<Team> teams,
                       final List<Player> players) {
        this.matchId = matchId;
        this.gameTime = gameTime;
        this.gameDate = gameDate;
        this.matchCategory = matchCategory;
        this.teams = teams;
        this.players = players;
    }
}
