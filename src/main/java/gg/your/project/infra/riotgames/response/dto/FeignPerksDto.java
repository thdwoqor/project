package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record FeignPerksDto(
        FeignPerkStatsDto statPerks,
        List<FeignPerkStyleDto> styles
) {
}
