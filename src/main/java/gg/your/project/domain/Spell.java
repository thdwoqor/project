package gg.your.project.domain;

import lombok.Getter;

@Getter
public class Spell {

    private final String id;
    private final String description;
    private final Integer key;

    public Spell(final String id, final String description, final Integer key) {
        this.id = id;
        this.description = description;
        this.key = key;
    }
}
