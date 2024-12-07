package gg.your.project.domain.spell;

import gg.your.project.infra.riotgames.ImageDataClient;
import gg.your.project.infra.riotgames.response.FeignSpellResponse;
import gg.your.project.infra.riotgames.response.dto.FeignSpellDataDto;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpellRepositoryImpl implements SpellRepository {

    private final ImageDataClient imageDataClient;
    private final Map<Integer, Spell> database = new ConcurrentHashMap<>();

    @Override
    public List<Spell> findAll() {
        return database.values().stream()
                .toList();
    }

    @PostConstruct
    public void initialize() {
        FeignSpellResponse spells = imageDataClient.getSpells();
        for (FeignSpellDataDto value : spells.data().values()) {
            database.put(
                    Integer.parseInt(value.key()),
                    new Spell(
                            Integer.parseInt(value.key()),
                            value.image().full()
                    )
            );
        }
    }
}
