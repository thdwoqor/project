package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.InfoDto;
import gg.your.project.infra.riotgames.response.dto.MetadataDto;

public record MatchResponse(
        MetadataDto metadata,
        InfoDto info
) {
}
