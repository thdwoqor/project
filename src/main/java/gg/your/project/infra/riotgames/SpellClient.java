package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.response.MatchResponse;
import gg.your.project.infra.riotgames.response.SpellResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RiotGamesSpellh", url = "https://ddragon.leagueoflegends.com")
public interface SpellClient {

    @GetMapping(value = "/cdn/14.23.1/data/en_US/summoner.json")
    SpellResponse getSpells();
}
