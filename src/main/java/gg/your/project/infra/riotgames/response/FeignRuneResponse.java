package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.FeignSlotDto;
import java.util.List;

public record FeignRuneResponse(
        String id,
        String key,
        String icon,
        String name,
        List<FeignSlotDto> slots
) {
}
