package gg.your.project.infra.riotgames.response.dto;

public record FeignRuneDto(
        String id,
        String key,
        String icon,
        String name,
        String shortDesc,
        String longDesc
) {
}
