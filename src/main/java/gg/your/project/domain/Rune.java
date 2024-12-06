package gg.your.project.domain;

import lombok.Getter;

@Getter
public class Rune {

    private final int id;
    private final String icon;
    private final String name;

    public Rune(final int id, final String icon, final String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }
}
