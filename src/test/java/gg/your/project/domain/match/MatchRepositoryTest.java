//package gg.your.project.domain.match;
//
//import gg.your.project.domain.MatchCategory;
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class MatchRepositoryTest {
//
//    @Autowired
//    private MatchRepository matchRepository;
//
//    @Test
//    void name() {
//        List<String> matchIds = List.of(
//                "KR_7393725536",
//                "KR_7393639377",
//                "KR_7391497819",
//                "KR_7391454608"
//        );
//
//        List<Match> matches = matchRepository.saveAll(List.of(
//                createMatch("KR_7391497819"),
//                createMatch("KR_7391454608")
//        ));
//
//        List<Match> allByMatchId = matchRepository.findAllByMatchIdIn(matchIds);
//        System.out.println(matches);
//    }
//
//    private static Match createMatch(final String matchId) {
//        return new Match(
//                matchId,
//                new MatchDetail()
//        );
//    }
//}
