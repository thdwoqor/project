package gg.your.project.infra.riotgames.response.dto;

import java.util.List;

public record MetadataDto(
        String dataVersion,
        String matchId,
        List<String> participants
) {
}
