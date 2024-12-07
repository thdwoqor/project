package gg.your.project.domain.match;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByMatchIdIn(final List<String> matchIds);
}
