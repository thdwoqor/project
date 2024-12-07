package gg.your.project.domain.rune;

import gg.your.project.infra.riotgames.ImageDataClient;
import gg.your.project.infra.riotgames.response.FeignRuneResponse;
import gg.your.project.infra.riotgames.response.dto.FeignRuneDto;
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
        List<FeignRuneDto> runes = imageDataClient.getRunes().stream()
                .flatMap(slot -> slot.slots().stream())
                .flatMap(rune -> rune.runes().stream())
                .toList();

        for (FeignRuneResponse rune : imageDataClient.getRunes()) {
            database.put(
                    Integer.parseInt(rune.id()),
                    new Rune(
                            Integer.parseInt(rune.id()),
                            rune.icon()
                    )
            );
        }

        for (FeignRuneDto rune : runes) {
            database.put(
                    Integer.parseInt(rune.id()),
                    new Rune(
                            Integer.parseInt(rune.id()),
                            rune.icon()
                    )
            );
        }
    }
}
