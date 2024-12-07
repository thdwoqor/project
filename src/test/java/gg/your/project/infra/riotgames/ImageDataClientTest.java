package gg.your.project.infra.riotgames;

import gg.your.project.domain.rune.Rune;
import gg.your.project.domain.rune.RuneRepository;
import gg.your.project.domain.spell.Spell;
import gg.your.project.domain.spell.SpellRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
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
    void 스펠_이미지_정보를_가져올_수_있다() {
        List<Spell> spells = spellRepository.findAll();

        Assertions.assertThat(spells).isNotEmpty();
    }

    @Test
    void 룬_이미지_정보를_가져올_수_있다() {
        List<Rune> runes = runeRepository.findAll();

        Assertions.assertThat(runes).isNotEmpty();
    }
}
