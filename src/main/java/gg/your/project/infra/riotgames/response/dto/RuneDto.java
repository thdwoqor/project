package gg.your.project.infra.riotgames.response.dto;

public record RuneDto(
        String id,
        String key,
        String icon,
        String name,
        String shortDesc,
        String longDesc
) {
}
