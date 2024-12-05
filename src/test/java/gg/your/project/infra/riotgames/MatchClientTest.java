package gg.your.project.infra.riotgames;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import gg.your.project.infra.riotgames.dto.MatchDetailResponse;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MatchClientTest {

    @Autowired
    private MatchClientImpl matchClient;

    @Test
    void 최근_매칭_id를_조회할_수_있다() {
        List<String> matchIds = matchClient.getMatchIds(
                "jfgcPI2_9rOZRAcsgkSf56G4RA_cZHxNu4yUWkZaSnL_XZPDp7noFnrPsfg_ENcB8NsDTHQ_JZ2wjA",
                13);
        Assertions.assertThat(matchIds).hasSize(13);
    }

    @Test
    void 매칭_상세_정보를_조회할_수_있다() {
        MatchDetailResponse response = matchClient.getMatchDetail("KR_7295591783");

        assertSoftly(softly -> {
            softly.assertThat(response.info()).isNotNull();
            softly.assertThat(response.metadata()).isNotNull();
        });
    }
}
