package gg.your.project.domain.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String puuid;
    private String gameName;
    private String tagline;
    private SearchFullName searchFullName;

    private Account(final String puuid, final String gameName, final String tagline,
                   final SearchFullName searchFullName) {
        validate(puuid, gameName, tagline);
        this.puuid = puuid;
        this.gameName = gameName;
        this.tagline = tagline;
        this.searchFullName = searchFullName;
    }

    public static Account from(final String puuid, final String gameName, final String tagline) {
        return new Account(puuid, gameName, tagline, SearchFullName.from(gameName + "#" + tagline));
    }

    private void validate(final String puuid, final String gameName, final String tagline) {
        if (puuid == null || gameName == null || tagline == null) {
            throw new IllegalArgumentException("닉네임을 찾을 수 없습니다.");
        }
    }

    public void update(final String puuid, final String gameName, final String tagline) {
        validate(puuid, gameName, tagline);
        this.puuid = puuid;
        this.gameName = gameName;
        this.tagline = tagline;
        this.searchFullName = SearchFullName.from(gameName + "#" + tagline);
    }
}
