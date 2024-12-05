package gg.your.project.infra.riotgames.dto;

import java.util.List;

public record MatchResponse(
        List<String> matchIds
) {
}
