package gg.your.project.domain.match;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String matchId;
    @Convert(converter = MatchDetailConverter.class)
    @Column(columnDefinition = "TEXT")
    private MatchDetail matchDetail;

    public Match(final String matchId, final MatchDetail matchDetail) {
        this.matchId = matchId;
        this.matchDetail = matchDetail;
    }
}
