package gg.your.project.infra.riotgames.dto;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public record PerkStatsDto(
    Integer defense,
    Integer flex,
    Integer offense
) {
}
