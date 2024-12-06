package gg.your.project.domain.account;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchFullName {

    private String searchFullName;

    private SearchFullName(final String searchFullName) {
        this.searchFullName = searchFullName;
    }

    public static SearchFullName from(final String fullName) {
        if (!fullName.contains("#")) {
            throw new IllegalArgumentException("태그를 확인해 주세요");
        }
        return new SearchFullName(fullName.replaceAll(" ", "")
                .toLowerCase());
    }
}
