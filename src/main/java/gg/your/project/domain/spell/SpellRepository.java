package gg.your.project.domain.spell;

import java.util.List;

public interface SpellRepository {
    List<Spell> findAll();
}
