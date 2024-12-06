package gg.your.project.infra.riotgames;

import gg.your.project.domain.rune.Rune;
import gg.your.project.domain.rune.RuneRepository;
import gg.your.project.domain.spell.Spell;
import gg.your.project.domain.spell.SpellRepository;
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
