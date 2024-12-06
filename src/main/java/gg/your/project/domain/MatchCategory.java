package gg.your.project.domain;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum MatchCategory {

    SOLO("솔로랭크", 420),
    TEAM("자유랭크", 440),
    NORMAL("일반", 430),
    ARAM("칼바람", 450);

    private final String name;
    private final int id;

    MatchCategory(final String name, final int id) {
        this.name = name;
        this.id = id;
    }

    public static MatchCategory from(final int id) {
        return Arrays.stream(MatchCategory.values())
                .filter(category -> category.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 매칭 타입 입니다."));
    }
}
