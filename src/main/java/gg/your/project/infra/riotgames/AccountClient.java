package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.response.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RiotGamesAccount", url = "https://asia.api.riotgames.com/riot/account/v1/accounts")
public interface AccountClient {

    @GetMapping(value = "/by-riot-id/{gameName}/{tagLine}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AccountResponse getAccount(
            @PathVariable("gameName") String gameName,
            @PathVariable("tagLine") String tagLine,
            @RequestParam("api_key") String api_key
    );
}
