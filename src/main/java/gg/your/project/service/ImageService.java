package gg.your.project.service;

import gg.your.project.domain.champion.Champion;
import gg.your.project.domain.champion.ChampionRepository;
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
    private final ChampionRepository championRepository;

    public Map<Integer, Spell> getAllSpellsByMap() {
        Map<Integer, Spell> spells = new HashMap<>();
        for (Spell spell : spellRepository.findAll()) {
            spells.put(spell.getId(), spell);
        }
        return spells;
    }

    public Map<Integer, Rune> getAllRunesByMap() {
        Map<Integer, Rune> runes = new HashMap<>();
        for (Rune rune : runeRepository.findAll()) {
            runes.put(rune.getId(), rune);
        }
        return runes;
    }

    public Map<Integer, Champion> getAllChampionByMap() {
        Map<Integer, Champion> champions = new HashMap<>();
        for (Champion rune : championRepository.findAll()) {
            champions.put(rune.getId(), rune);
        }
        return champions;
    }
}
