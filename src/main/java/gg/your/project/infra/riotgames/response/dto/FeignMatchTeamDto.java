package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record FeignMatchTeamDto(
        List<FeignBanDto> bans,
        FeignObjectivesDto objectives,
        Integer teamId,
        Boolean win
) {
}
