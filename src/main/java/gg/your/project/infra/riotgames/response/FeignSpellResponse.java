package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.FeignSpellDataDto;
import java.util.Map;

public record FeignSpellResponse(
        Map<String, FeignSpellDataDto> data
) {
}
