package gg.your.project.service.dto;

import gg.your.project.domain.TeamCategory;
import gg.your.project.infra.riotgames.response.dto.FeignMatchTeamDto;
import java.util.List;
import lombok.Builder;

@Builder
public record TeamDto(
        int kills,
        int gold,
        int baron, //바론
        int dragon, //용
        int horde, //유충
        int riftHerald, //전령
        int inhibitor, //억제기
        int tower, //타워
        TeamCategory teamCategory,
        boolean win
) {
    public static TeamDto from(final FeignMatchTeamDto dto, List<PlayerDto> players) {
        int totalGold = players.stream()
                .filter(player -> player.teamId() == dto.teamId())
                .mapToInt(PlayerDto::goldEarned)
                .sum();

        return TeamDto.builder()
                .kills(dto.objectives().champion().kills())
                .gold(totalGold)
                .baron(dto.objectives().baron().kills())
                .dragon(dto.objectives().dragon().kills())
                .horde(dto.objectives().horde().kills())
                .riftHerald(dto.objectives().riftHerald().kills())
                .inhibitor(dto.objectives().inhibitor().kills())
                .tower(dto.objectives().tower().kills())
                .teamCategory(TeamCategory.from(dto.teamId()))
                .win(dto.win())
                .build();
    }
}
