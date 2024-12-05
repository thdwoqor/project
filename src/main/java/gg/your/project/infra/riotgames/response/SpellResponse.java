package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.SpellDataDto;
import java.util.Map;

public record SpellResponse(
        Map<String, SpellDataDto> data
) {
}
