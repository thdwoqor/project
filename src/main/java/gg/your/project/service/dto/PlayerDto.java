package gg.your.project.service.dto;

import gg.your.project.infra.riotgames.response.dto.ParticipantDto;
import java.util.List;
import lombok.Builder;

@Builder
public record PlayerDto(
        String riotIdGameName, //라이엇 이름
        String riotIdTagline, //라이엇 태그
        String summonerName, //소환사 이름
        int spellD, //소환사 주문 D
        int spellF, //소환사 주문 F
        int teamId, //100이면 블루, 200이면 퍼플
        String teamPosition, //어느 라인인지 추정 (탑1, 미드1, 정글1, 바텀2 제약)
        String individualPosition, //어느 라인인지 추정 (제약 없음)
        String lane, //랭크에서 정해진 라인
        int champLevel, //챔피언 레벨
        String championName, //챔피언 이름
        int cs, //cs
        double csPerMinute, //분당 cs
        double kda, //kda
        int kills, //킬
        int assists, //어시
        int deaths, //데스
        int controlWardsPlaced, //제어 와드
        int wardsPlaced, //일반 와드
        int wardsKilled, //와드 제거
        int visionWardsBoughtInGame, //제어 와드
        int goldEarned, //획득 골드
        int totalChampionsDamage, //챔피언 마법피해+챔피언 물리피해
        boolean win,
        List<Integer> items, //아이템
        RuneDto runs //룬
) {
    public static PlayerDto from(final ParticipantDto dto, final long gameTime) {
        int totalCs = getTotalCs(dto);
        return PlayerDto.builder().
                riotIdGameName(dto.riotIdGameName())
                .riotIdTagline(dto.riotIdTagline())
                .summonerName(dto.summonerName())
                .spellD(dto.summoner1Id())
                .spellF(dto.summoner2Id())
                .teamId(dto.teamId())
                .teamPosition(dto.teamPosition())
                .individualPosition(dto.individualPosition())
                .lane(dto.lane())
                .champLevel(dto.champLevel())
                .championName(dto.championName())
                .cs(totalCs)
                .csPerMinute(totalCs / ((double) gameTime / 60))
                .kda(dto.challenges().kda())
                .kills(dto.kills())
                .assists(dto.assists())
                .deaths(dto.deaths())
                .controlWardsPlaced(dto.challenges().controlWardsPlaced())
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
                .runs(RuneDto.from(dto.perks()))
                .build();
    }

    private static int getTotalCs(final ParticipantDto dto) {
        return dto.totalMinionsKilled() +
                dto.neutralMinionsKilled();
    }
}
