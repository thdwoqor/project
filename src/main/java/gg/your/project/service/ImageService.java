package gg.your.project.service;

import gg.your.project.domain.rune.RuneRepository;
import gg.your.project.domain.rune.Rune;
import gg.your.project.domain.spell.Spell;
import gg.your.project.domain.spell.SpellRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final SpellRepository spellRepository;
    private final RuneRepository runeRepository;

    public Map<Integer, Spell> getAllSpellsByMap() {
        Map<Integer, Spell> spells = new HashMap<>();
        for (Spell spell : spellRepository.findByAll()) {
            spells.put(spell.getKey(), spell);
        }
        return spells;
    }

    public Map<Integer, Rune> getAllRunesByMap() {
        Map<Integer, Rune> runes = new HashMap<>();
        for (Rune rune : runeRepository.findByAll()) {
            runes.put(rune.getId(), rune);
        }
        return runes;
    }
}
