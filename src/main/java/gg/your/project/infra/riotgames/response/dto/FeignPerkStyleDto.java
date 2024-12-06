package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record FeignPerkStyleDto(
    String description,
    List<FeignPerkStyleSelectionDto> selections,
    Integer style
) {
}
