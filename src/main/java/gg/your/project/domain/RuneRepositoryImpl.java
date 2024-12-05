package gg.your.project.domain;

import gg.your.project.infra.riotgames.ImageDataClient;
import gg.your.project.infra.riotgames.response.RuneResponse;
import gg.your.project.infra.riotgames.response.dto.RuneDto;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RuneRepositoryImpl implements RuneRepository {

    private final ImageDataClient imageDataClient;
    private final Map<Integer, Rune> database = new ConcurrentHashMap<>();

    @Override
    public List<Rune> findByAll() {
        return database.values().stream()
                .toList();
    }

    @PostConstruct
    public void initialize() {
        List<RuneDto> runes = imageDataClient.getRunes().stream()
                .flatMap(slot -> slot.slots().stream())
                .flatMap(rune -> rune.runes().stream())
                .toList();

        for (RuneResponse rune : imageDataClient.getRunes()) {
            database.put(
                    Integer.parseInt(rune.id()),
                    new Rune(
                            Integer.parseInt(rune.id()),
                            rune.icon(),
                            rune.name()
                    )
            );
        }

        for (RuneDto rune : runes) {
            database.put(
                    Integer.parseInt(rune.id()),
                    new Rune(
                            Integer.parseInt(rune.id()),
                            rune.icon(),
                            rune.name()
                    )
            );
        }
    }
}
