package gg.your.project.infra.riotgames.response;

public record FeignAccountResponse(
        String puuid,
        String gameName,
        String tagLine
) {
}
