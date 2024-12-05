package gg.your.project.service.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record MatchResponse(
        String matchId,
        long gameTime, //게임 시간(초)
        long gameDate, //게임 날짜(초)
        int queueId, //큐 정보 (420: 솔랭, 430: 일반, 440: 자유랭, 450: 칼바람)
        List<TeamDto> teams,
        List<PlayerDto> players
) {
    public static MatchResponse from(final gg.your.project.infra.riotgames.response.MatchResponse response) {
        List<PlayerDto> players = response.info().participants().stream()
                .map(PlayerDto::from)
                .toList();

        List<TeamDto> teams = response.info()
                .teams()
                .stream()
                .map(team -> TeamDto.from(team, players))
                .toList();

        return MatchResponse.builder()
                .matchId(response.metadata().matchId())
                .gameTime(response.info().gameDuration())
                .gameDate(response.info().gameCreation())
                .queueId(response.info().queueId())
                .teams(teams)
                .players(players)
                .build();
    }
}
