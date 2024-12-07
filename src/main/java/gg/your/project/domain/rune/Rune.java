package gg.your.project.domain.rune;

import lombok.Getter;

@Getter
public class Rune {

    private final int id;
    private final String image;

    public Rune(final int id, final String image) {
        this.id = id;
        this.image = image;
    }
}
