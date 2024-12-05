package gg.your.project.service.dto;

import gg.your.project.infra.riotgames.response.dto.PerksDto;
import java.util.List;

public record RuneDto(
        int primaryPageId,
        List<Integer> primaryRuneIds,
        int secondaryPageId,
        List<Integer> secondaryRuneIds,
        List<Integer> statModIds
) {

    public static RuneDto from(final PerksDto dto) {
        return new RuneDto(
                dto.styles().get(0).style(),
                List.of(
                        dto.styles().get(0).selections().get(0).perk(),
                        dto.styles().get(0).selections().get(1).perk(),
                        dto.styles().get(0).selections().get(2).perk(),
                        dto.styles().get(0).selections().get(3).perk()
                ),
                dto.styles().get(1).style(),
                List.of(
                        dto.styles().get(1).selections().get(0).perk(),
                        dto.styles().get(1).selections().get(1).perk()
                ),
                List.of(
                        dto.statPerks().defense(),
                        dto.statPerks().flex(),
                        dto.statPerks().offense()
                )
        );
    }
}
