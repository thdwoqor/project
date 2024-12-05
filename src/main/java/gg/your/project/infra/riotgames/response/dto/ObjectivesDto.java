package gg.your.project.infra.riotgames.response.dto;

public record ObjectivesDto(
        ObjectiveDto baron,
        ObjectiveDto champion,
        ObjectiveDto dragon,
        ObjectiveDto horde,
        ObjectiveDto inhibitor,
        ObjectiveDto riftHerald,
        ObjectiveDto tower
) {
}
