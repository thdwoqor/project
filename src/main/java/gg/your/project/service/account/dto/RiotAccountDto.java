package gg.your.project.service.account.dto;

import gg.your.project.infra.riotgames.response.AccountResponse;

public record RiotAccountDto(
        String puuid,
        String gameName,
        String tagLine
) {
    public static RiotAccountDto from(final AccountResponse response) {
        return new RiotAccountDto(
                response.puuid(),
                response.gameName(),
                response.tagLine()
        );
    }
}
