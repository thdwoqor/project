package gg.your.project.infra.riotgames.dto;

import java.util.List;

public record TeamDto(
        List<BanDto> bans,
        ObjectivesDto objectives,
        Integer teamId,
        Boolean win
) {
}
