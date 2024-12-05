package gg.your.project.service;

import gg.your.project.domain.Spell;
import gg.your.project.domain.SpellRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpellService {

    private final SpellRepository spellRepository;

    public Map<Integer, Spell> getAllSpellsAsMap() {
        Map<Integer, Spell> spells = new HashMap<>();
        for (Spell spell : spellRepository.findByAll()) {
            spells.put(spell.getKey(), spell);
        }
        return spells;
    }
}
