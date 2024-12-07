package gg.your.project.infra.riotgames;

import gg.your.project.infra.riotgames.response.FeignChampionResponse;
import gg.your.project.infra.riotgames.response.FeignRuneResponse;
import gg.your.project.infra.riotgames.response.FeignSpellResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RiotGamesImageData", url = "https://ddragon.leagueoflegends.com")
public interface ImageDataClient {

    @GetMapping(value = "/cdn/14.23.1/data/ko_KR/summoner.json")
    FeignSpellResponse getSpells();

    @GetMapping(value = "/cdn/14.23.1/data/ko_KR/runesReforged.json")
    List<FeignRuneResponse> getRunes();

    @GetMapping(value = "/cdn/14.23.1/data/ko_KR/champion.json")
    FeignChampionResponse getChampion();
}
