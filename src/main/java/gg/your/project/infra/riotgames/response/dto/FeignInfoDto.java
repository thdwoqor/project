package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record FeignInfoDto(
        String endOfGameResult,
        Long gameCreation,
        Long gameDuration,
        Long gameEndTimestamp,
        Long gameId,
        String gameMode,
        String gameName,
        Long gameStartTimestamp,
        String gameType,
        String gameVersion,
        Integer mapId,
        List<FeignParticipantDto> participants,
        String platformId,
        Integer queueId,
        List<FeignMatchTeamDto> teams,
        String tournamentCode
) {
}
