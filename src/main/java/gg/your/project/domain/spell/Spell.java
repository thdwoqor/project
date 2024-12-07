package gg.your.project.domain.spell;

import lombok.Getter;

@Getter
public class Spell {

    private final int id;
    private final String image;

    public Spell(final Integer id, final String image) {
        this.id = id;
        this.image = image;
    }
}
