package gg.your.project.service.dto;

import gg.your.project.domain.TeamCategory;
import gg.your.project.domain.match.Player;
import gg.your.project.infra.riotgames.response.dto.FeignParticipantDto;
import java.util.List;
import lombok.Builder;

@Builder
public record PlayerDto(
        String riotIdGameName, //라이엇 이름
        String riotIdTagline, //라이엇 태그
        String summonerName, //소환사 이름
        int spellD, //소환사 주문 D
        int spellF, //소환사 주문 F
        TeamCategory teamCategory, //100이면 블루, 200이면 퍼플
        String lane, //랭크에서 정해진 라인
        int champLevel, //챔피언 레벨
        String championName, //챔피언 이름
        int cs, //cs
        double csPerMinute, //분당 cs
        double kda, //kda
        int kills, //킬
        int assists, //어시
        int deaths, //데스
        int wardsPlaced, //일반 와드
        int wardsKilled, //와드 제거
        int visionWardsBoughtInGame, //제어 와드 구매 횟수
        int goldEarned, //획득 골드
        int totalChampionsDamage, //챔피언 마법피해+챔피언 물리피해
        boolean win,
        List<Integer> items, //아이템
        int primaryPageId,
        List<Integer> primaryRuneIds,
        int secondaryPageId,
        List<Integer> secondaryRuneIds,
        List<Integer> statModIds
) {
    public Player toPlayer() {
        return Player.builder()
                .riotIdGameName(riotIdGameName)
                .riotIdTagline(riotIdTagline)
                .summonerName(summonerName)
                .spellD(spellD)
                .spellF(spellF)
                .teamCategory(teamCategory)
                .lane(lane)
                .champLevel(champLevel)
                .championName(championName)
                .cs(cs)
                .csPerMinute(csPerMinute)
                .kda(kda)
                .kills(kills)
                .assists(assists)
                .deaths(deaths)
                .wardsPlaced(wardsPlaced)
                .wardsKilled(wardsKilled)
                .visionWardsBoughtInGame(visionWardsBoughtInGame)
                .goldEarned(goldEarned)
                .totalChampionsDamage(totalChampionsDamage)
                .win(win)
                .items(items)
                .primaryPageId(primaryPageId)
                .primaryRuneIds(primaryRuneIds)
                .secondaryPageId(secondaryPageId)
                .secondaryRuneIds(secondaryRuneIds)
                .statModIds(statModIds)
                .build();
    }

    public static PlayerDto from(final Player player) {
        return PlayerDto.builder().
                riotIdGameName(player.getRiotIdGameName())
                .riotIdTagline(player.getRiotIdTagline())
                .summonerName(player.getSummonerName())
                .spellD(player.getSpellD())
                .spellF(player.getSpellF())
                .teamCategory(player.getTeamCategory())
                .lane(player.getLane())
                .champLevel(player.getChampLevel())
                .championName(player.getChampionName())
                .cs(player.getCs())
                .csPerMinute(player.getCsPerMinute())
                .kda(player.getKda())
                .kills(player.getKills())
                .assists(player.getAssists())
                .deaths(player.getDeaths())
                .wardsPlaced(player.getWardsPlaced())
                .wardsKilled(player.getWardsKilled())
                .visionWardsBoughtInGame(player.getVisionWardsBoughtInGame())
                .goldEarned(player.getGoldEarned())
                .totalChampionsDamage(player.getTotalChampionsDamage())
                .win(player.isWin())
                .items(player.getItems())
                .primaryPageId(player.getPrimaryPageId())
                .primaryRuneIds(player.getPrimaryRuneIds())
                .secondaryPageId(player.getSecondaryPageId())
                .secondaryRuneIds(player.getSecondaryRuneIds())
                .statModIds(player.getStatModIds())
                .build();
    }

    public static PlayerDto from(final FeignParticipantDto dto, final long gameTime) {
        int totalCs = getTotalCs(dto);
        return PlayerDto.builder().
                riotIdGameName(dto.riotIdGameName())
                .riotIdTagline(dto.riotIdTagline())
                .summonerName(dto.summonerName())
                .spellD(dto.summoner1Id())
                .spellF(dto.summoner2Id())
                .teamCategory(TeamCategory.from(dto.teamId()))
                .lane(dto.lane())
                .champLevel(dto.champLevel())
                .championName(dto.championName())
                .cs(totalCs)
                .csPerMinute(totalCs / ((double) gameTime / 60))
                .kda(dto.challenges().kda())
                .kills(dto.kills())
                .assists(dto.assists())
                .deaths(dto.deaths())
                .wardsPlaced(dto.wardsPlaced())
                .wardsKilled(dto.wardsKilled())
                .visionWardsBoughtInGame(dto.visionWardsBoughtInGame())
                .goldEarned(dto.goldEarned())
                .totalChampionsDamage(dto.magicDamageDealtToChampions() + dto.physicalDamageDealtToChampions())
                .win(dto.win())
                .items(List.of(
                        dto.item0(),
                        dto.item1(),
                        dto.item2(),
                        dto.item3(),
                        dto.item4(),
                        dto.item5(),
                        dto.item6()
                ))
                .primaryPageId(dto.perks().styles().get(0).style())
                .primaryRuneIds(List.of(
                        dto.perks().styles().get(0).selections().get(0).perk(),
                        dto.perks().styles().get(0).selections().get(1).perk(),
                        dto.perks().styles().get(0).selections().get(2).perk(),
                        dto.perks().styles().get(0).selections().get(3).perk()
                ))
                .secondaryPageId(dto.perks().styles().get(1).style())
                .secondaryRuneIds(List.of(
                        dto.perks().styles().get(1).selections().get(0).perk(),
                        dto.perks().styles().get(1).selections().get(1).perk()
                ))
                .statModIds(List.of(
                        dto.perks().statPerks().defense(),
                        dto.perks().statPerks().flex(),
                        dto.perks().statPerks().offense()
                ))
                .build();
    }

    private static int getTotalCs(final FeignParticipantDto dto) {
        return dto.totalMinionsKilled() +
                dto.neutralMinionsKilled();
    }
}
