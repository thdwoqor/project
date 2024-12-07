package gg.your.project.domain.match;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findByMatchId(final String matchId);
    List<Match> findAllByMatchIdIn(final List<String> matchIds);
}
