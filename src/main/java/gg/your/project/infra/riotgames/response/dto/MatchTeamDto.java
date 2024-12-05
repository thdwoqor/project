package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record MatchTeamDto(
        List<BanDto> bans,
        ObjectivesDto objectives,
        Integer teamId,
        Boolean win
) {
}
