package gg.your.project.infra.riotgames;

import gg.your.project.service.dto.MatchResponse;
import gg.your.project.service.match.RiotMatchProvider;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MatchClientTest {

    @Autowired
    private RiotMatchProvider matchClient;

    @Test
    void 최근_매칭_id를_조회할_수_있다() {
        List<String> matchIds = matchClient.findMatchIds(
                "jfgcPI2_9rOZRAcsgkSf56G4RA_cZHxNu4yUWkZaSnL_XZPDp7noFnrPsfg_ENcB8NsDTHQ_JZ2wjA",
                13);

        Assertions.assertThat(matchIds).hasSize(13);
    }

    @Test
    void 매칭_상세_정보를_조회할_수_있다() {
        MatchResponse matchResponse = matchClient.findMatch("KR_7295591783");

        Assertions.assertThat(matchResponse.matchId()).isEqualTo("KR_7295591783");
    }
}
