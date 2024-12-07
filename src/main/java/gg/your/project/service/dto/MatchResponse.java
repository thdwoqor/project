package gg.your.project.service.dto;

import gg.your.project.domain.MatchCategory;
import gg.your.project.domain.match.Match;
import gg.your.project.domain.match.MatchDetail;
import gg.your.project.infra.riotgames.response.FeignMatchResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import lombok.Builder;

@Builder
public record MatchResponse(
        String matchId,
        long gameTime, //게임 시간(초)
        LocalDateTime gameDate, //게임 날짜
        MatchCategory matchCategory, //큐 정보
        List<TeamDto> teams,
        List<PlayerDto> players
) {
    public Match toMatch() {
        MatchDetail matchDetail = MatchDetail.builder()
                .matchId(matchId)
                .gameTime(gameTime)
                .gameDate(gameDate)
                .matchCategory(matchCategory)
                .teams(teams.stream()
                        .map(TeamDto::toTeam)
                        .toList())
                .players(players.stream()
                        .map(PlayerDto::toPlayer)
                        .toList())
                .build();
        return new Match(matchId, matchDetail);
    }

    public static MatchResponse from(final Match match) {
        return MatchResponse.builder()
                .matchId(match.getMatchId())
                .gameTime(match.getMatchDetail().getGameTime())
                .gameDate(match.getMatchDetail().getGameDate())
                .matchCategory(match.getMatchDetail().getMatchCategory())
                .teams(match.getMatchDetail()
                        .getTeams()
                        .stream()
                        .map(TeamDto::from)
                        .toList())
                .players(match.getMatchDetail()
                        .getPlayers()
                        .stream()
                        .map(PlayerDto::from)
                        .toList())
                .build();
    }

    public static MatchResponse from(final FeignMatchResponse response) {
        List<PlayerDto> players = response.info().participants().stream()
                .map(player -> PlayerDto.from(player, response.info().gameDuration()))
                .toList();

        List<TeamDto> teams = response.info()
                .teams()
                .stream()
                .map(team -> TeamDto.from(team, players))
                .toList();

        LocalDateTime gameDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(response.info().gameCreation()), TimeZone
                .getDefault().toZoneId());

        return MatchResponse.builder()
                .matchId(response.metadata().matchId())
                .gameTime(response.info().gameDuration())
                .gameDate(gameDate)
                .matchCategory(MatchCategory.from(response.info().queueId()))
                .teams(teams)
                .players(players)
                .build();
    }
}
