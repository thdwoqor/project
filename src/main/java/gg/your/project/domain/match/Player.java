package gg.your.project.domain.match;

import gg.your.project.domain.TeamCategory;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Player {
    private final String riotIdGameName;
    private final String riotIdTagline;
    private final String summonerName;
    private final int spellD;
    private final int spellF;
    private final TeamCategory teamCategory;
    private final String lane;
    private final int champLevel;
    private final String championName;
    private final int cs;
    private final double csPerMinute;
    private final double kda;
    private final int kills;
    private final int assists;
    private final int deaths;
    private final int wardsPlaced;
    private final int wardsKilled;
    private final int visionWardsBoughtInGame;
    private final int goldEarned;
    private final int totalChampionsDamage;
    private final boolean win;
    private final List<Integer> items;
    private final int primaryPageId;
    private final List<Integer> primaryRuneIds;
    private final int secondaryPageId;
    private final List<Integer> secondaryRuneIds;
    private final List<Integer> statModIds;

    public Player(final String riotIdGameName, final String riotIdTagline, final String summonerName, final int spellD,
                  final int spellF,
                  final TeamCategory teamCategory, final String lane, final int champLevel, final String championName,
                  final int cs, final double csPerMinute,
                  final double kda, final int kills, final int assists, final int deaths, final int wardsPlaced,
                  final int wardsKilled,
                  final int visionWardsBoughtInGame, final int goldEarned, final int totalChampionsDamage,
                  final boolean win, final List<Integer> items,
                  final int primaryPageId, final List<Integer> primaryRuneIds, final int secondaryPageId,
                  final List<Integer> secondaryRuneIds,
                  final List<Integer> statModIds) {
        this.riotIdGameName = riotIdGameName;
        this.riotIdTagline = riotIdTagline;
        this.summonerName = summonerName;
        this.spellD = spellD;
        this.spellF = spellF;
        this.teamCategory = teamCategory;
        this.lane = lane;
        this.champLevel = champLevel;
        this.championName = championName;
        this.cs = cs;
        this.csPerMinute = csPerMinute;
        this.kda = kda;
        this.kills = kills;
        this.assists = assists;
        this.deaths = deaths;
        this.wardsPlaced = wardsPlaced;
        this.wardsKilled = wardsKilled;
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
        this.goldEarned = goldEarned;
        this.totalChampionsDamage = totalChampionsDamage;
        this.win = win;
        this.items = items;
        this.primaryPageId = primaryPageId;
        this.primaryRuneIds = primaryRuneIds;
        this.secondaryPageId = secondaryPageId;
        this.secondaryRuneIds = secondaryRuneIds;
        this.statModIds = statModIds;
    }
}
