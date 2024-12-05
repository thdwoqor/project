package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.response.RiotMatchResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RiotGamesMatch", url = "https://asia.api.riotgames.com/lol/match/v5/matches")
public interface MatchClient {

    @GetMapping(value = "/by-puuid/{puuid}/ids?start=0", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<String> getMatchIds(
            @PathVariable("puuid") String puuid,
            @RequestParam("api_key") String apiKey,
            @RequestParam("count") int count
    );

    @GetMapping(value = "/{matchId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    RiotMatchResponse getMatchDetail(
            @PathVariable("matchId") String matchId,
            @RequestParam("api_key") String apiKey
    );
}
