package gg.your.project.infra.riotgames.dto;

import java.util.List;

public record PerksDto(
        PerkStatsDto statPerks,
        List<PerkStyleDto> styles
) {
}
