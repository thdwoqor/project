package gg.your.project.domain.champion;

import lombok.Getter;

@Getter
public class Champion {

    private final int id;
    private final String image;

    public Champion(final int id, final String image) {
        this.id = id;
        this.image = image;
    }
}
