package gg.your.project.service.match;

import gg.your.project.domain.match.Match;
import gg.your.project.domain.match.MatchRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    @Transactional(readOnly = true)
    public List<Match> findAllByMatchIdIn(List<String> matchIds){
        return matchRepository.findAllByMatchIdIn(matchIds);
    }

    public List<Match> saveAll(List<Match> matches){
        return matchRepository.saveAll(matches);
    }
}
