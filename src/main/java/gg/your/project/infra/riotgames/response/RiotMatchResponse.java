package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.InfoDto;
import gg.your.project.infra.riotgames.response.dto.MetadataDto;

public record RiotMatchResponse(
        MetadataDto metadata,
        InfoDto info
) {
}
