package gg.your.project.service.dto;

import gg.your.project.domain.TeamCategory;
import gg.your.project.domain.match.Team;
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
    public Team toTeam() {
        return Team.builder()
                .kills(kills)
                .gold(gold)
                .baron(baron)
                .dragon(dragon)
                .horde(horde)
                .riftHerald(riftHerald)
                .inhibitor(inhibitor)
                .tower(tower)
                .teamCategory(teamCategory)
                .win(win)
                .build();

    }

    public static TeamDto from(final Team team) {
        return TeamDto.builder()
                .kills(team.getKills())
                .gold(team.getGold())
                .baron(team.getBaron())
                .dragon(team.getDragon())
                .horde(team.getHorde())
                .riftHerald(team.getRiftHerald())
                .inhibitor(team.getInhibitor())
                .tower(team.getTower())
                .teamCategory(team.getTeamCategory())
                .win(team.isWin())
                .build();
    }

    public static TeamDto from(final FeignMatchTeamDto dto, List<PlayerDto> players) {
        int totalGold = players.stream()
                .filter(player -> player.teamCategory() == TeamCategory.from(dto.teamId()))
                .mapToInt(PlayerDto::goldEarned)
                .sum();

        return TeamDto.builder()
                .kills(dto.objectives().champion().kills())
                .gold(totalGold)
                .baron(dto.objectives().baron().kills())
                .dragon(dto.objectives().dragon().kills())
                .horde((dto.objectives().horde() != null) ? dto.objectives().horde().kills() : 0)
                .riftHerald((dto.objectives().riftHerald() != null) ? dto.objectives().riftHerald().kills() : 0)
                .inhibitor(dto.objectives().inhibitor().kills())
                .tower(dto.objectives().tower().kills())
                .teamCategory(TeamCategory.from(dto.teamId()))
                .win(dto.win())
                .build();
    }
}
