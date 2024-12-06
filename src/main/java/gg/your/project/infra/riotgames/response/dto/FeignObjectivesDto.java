package gg.your.project.infra.riotgames.response.dto;

public record FeignObjectivesDto(
        FeignObjectiveDto baron,
        FeignObjectiveDto champion,
        FeignObjectiveDto dragon,
        FeignObjectiveDto horde,
        FeignObjectiveDto inhibitor,
        FeignObjectiveDto riftHerald,
        FeignObjectiveDto tower
) {
}
