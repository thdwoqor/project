package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.FeignChampionDataDto;
import java.util.Map;

public record FeignChampionResponse(
        Map<String, FeignChampionDataDto> data
) {
}
