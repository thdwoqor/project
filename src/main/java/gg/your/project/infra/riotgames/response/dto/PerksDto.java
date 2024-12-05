package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record PerksDto(
        PerkStatsDto statPerks,
        List<PerkStyleDto> styles
) {
}
