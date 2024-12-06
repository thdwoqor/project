package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record FeignSlotDto(
        List<FeignRuneDto> runes
) {
}
