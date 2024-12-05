package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.response.RuneResponse;
import gg.your.project.infra.riotgames.response.SpellResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RiotGamesImageData", url = "https://ddragon.leagueoflegends.com")
public interface ImageDataClient {

    @GetMapping(value = "/cdn/14.23.1/data/ko_KR/summoner.json")
    SpellResponse getSpells();

    @GetMapping(value = "/cdn/14.23.1/data/ko_KR/runesReforged.json")
    List<RuneResponse> getRunes();
}
