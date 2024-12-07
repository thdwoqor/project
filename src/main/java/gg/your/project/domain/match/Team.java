package gg.your.project.domain.match;

import gg.your.project.domain.TeamCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class Team {
    private final int kills;
    private final int gold;
    private final int baron;
    private final int dragon;
    private final int horde;
    private final int riftHerald;
    private final int inhibitor;
    private final int tower;
    private final TeamCategory teamCategory;
    private final boolean win;

    public Team(final int kills, final int gold, final int baron, final int dragon, final int horde,
                final int riftHerald, final int inhibitor, final int tower,
                final TeamCategory teamCategory, final boolean win) {
        this.kills = kills;
        this.gold = gold;
        this.baron = baron;
        this.dragon = dragon;
        this.horde = horde;
        this.riftHerald = riftHerald;
        this.inhibitor = inhibitor;
        this.tower = tower;
        this.teamCategory = teamCategory;
        this.win = win;
    }

}
