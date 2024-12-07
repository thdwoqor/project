package gg.your.project.domain.champion;

import gg.your.project.domain.rune.Rune;
import gg.your.project.domain.rune.RuneRepository;
import gg.your.project.infra.riotgames.ImageDataClient;
import gg.your.project.infra.riotgames.response.FeignChampionResponse;
import gg.your.project.infra.riotgames.response.FeignRuneResponse;
import gg.your.project.infra.riotgames.response.dto.FeignChampionDataDto;
import gg.your.project.infra.riotgames.response.dto.FeignRuneDto;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChampionRepositoryImpl implements ChampionRepository {

    private final ImageDataClient imageDataClient;
    private final Map<Integer, Champion> database = new ConcurrentHashMap<>();

    @Override
    public List<Champion> findAll() {
        return database.values().stream()
                .toList();
    }

    @PostConstruct
    public void initialize() {
        FeignChampionResponse champions = imageDataClient.getChampion();
        for (FeignChampionDataDto champion : champions.data().values()) {
            database.put(
                    Integer.parseInt(champion.key()),
                    new Champion(
                            Integer.parseInt(champion.key()),
                            champion.image().full()
                    )
            );
        }
    }
}
