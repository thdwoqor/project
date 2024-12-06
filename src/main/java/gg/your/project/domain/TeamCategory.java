package gg.your.project.domain;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TeamCategory {
    BLUE("블루팀", 100),
    RED("레드팀", 200);

    private final String name;
    private final int id;

    TeamCategory(final String name, final int id) {
        this.name = name;
        this.id = id;
    }

    public static TeamCategory from(final int id) {
        return Arrays.stream(TeamCategory.values())
                .filter(category -> category.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 매칭 타입 입니다."));
    }
}
