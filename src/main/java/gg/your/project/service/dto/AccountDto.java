package gg.your.project.service.dto;

import gg.your.project.infra.riotgames.response.AccountResponse;

public record AccountDto(
        String puuid,
        String gameName,
        String tagLine
) {
    public static AccountDto from(final AccountResponse response) {
        return new AccountDto(
                response.puuid(),
                response.gameName(),
                response.tagLine()
        );
    }
}
