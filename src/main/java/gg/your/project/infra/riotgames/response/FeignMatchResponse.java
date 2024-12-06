package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.FeignInfoDto;
import gg.your.project.infra.riotgames.response.dto.FeignMetadataDto;

public record FeignMatchResponse(
        FeignMetadataDto metadata,
        FeignInfoDto info
) {
}
