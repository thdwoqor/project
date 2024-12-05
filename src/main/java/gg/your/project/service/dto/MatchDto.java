package gg.your.project.service.dto;

import gg.your.project.infra.riotgames.response.MatchResponse;
import java.util.List;
import lombok.Builder;

@Builder
public record MatchDto(
        String matchId,
        long gameTime, //게임 시간(초)
        long gameDate, //게임 날짜(초)
        int queueId, //큐 정보 (420: 솔랭, 430: 일반, 440: 자유랭, 450: 칼바람)
        List<TeamDto> teams,
        List<PlayerDto> players
) {
    public static MatchDto from(final MatchResponse response) {
        List<PlayerDto> players = response.info().participants().stream()
                .map(PlayerDto::from)
                .toList();

        List<TeamDto> teams = response.info()
                .teams()
                .stream()
                .map(team -> TeamDto.from(team, players))
                .toList();

        return MatchDto.builder()
                .matchId(response.metadata().matchId())
                .gameTime(response.info().gameDuration())
                .gameDate(response.info().gameCreation())
                .queueId(response.info().queueId())
                .teams(teams)
                .players(players)
                .build();
    }
}
