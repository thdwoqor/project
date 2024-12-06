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

    public Account(final String puuid, final String gameName, final String tagline, final SearchFullName searchFullName) {
        this.puuid = puuid;
        this.gameName = gameName;
        this.tagline = tagline;
        this.searchFullName = searchFullName;
    }

}
