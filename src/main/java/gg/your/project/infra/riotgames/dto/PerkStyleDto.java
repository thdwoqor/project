package gg.your.project.infra.riotgames.dto;

import java.util.List;

public record PerkStyleDto(
    String description,
    List<PerkStyleSelectionDto> selections,
    Integer style
) {
}
