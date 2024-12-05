package gg.your.project.infra.riotgames;

import static org.junit.jupiter.api.Assertions.*;

import gg.your.project.domain.Rune;
import gg.your.project.domain.RuneRepository;
import gg.your.project.domain.Spell;
import gg.your.project.domain.SpellRepository;
import gg.your.project.infra.riotgames.response.RuneResponse;
import gg.your.project.infra.riotgames.response.SpellResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImageDataClientTest {

    @Autowired
    private SpellRepository spellRepository;
    @Autowired
    private RuneRepository runeRepository;

    @Test
    void name() {
        List<Spell> spells = spellRepository.findByAll();
        System.out.println(spells);
    }

    @Test
    void name2() {
        List<Rune> runes = runeRepository.findByAll();
        System.out.println(runes);
    }
}
