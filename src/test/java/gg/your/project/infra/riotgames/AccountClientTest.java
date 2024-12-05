package gg.your.project.infra.riotgames;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import gg.your.project.infra.riotgames.dto.AccountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountClientTest {

    @Autowired
    private AccountClientImpl accountClient;

    @Test
    void 라이엇_고유_id_를_조회_할_수_있다() {
        AccountResponse account = accountClient.getAccount("난 우리팀의 노력과 열정을 믿", "kr2");

        assertSoftly(softly -> {
            softly.assertThat(account.puuid())
                    .isEqualTo("ViTWAPeD2jN85dC73cO189WxMxSkfru1R5gGcFnMGBdp6gaTFE-c1mpDGrs3nxLKNGCHXnvQ502azQ");
            softly.assertThat(account.gameName())
                    .isEqualTo("난 우리팀의 노력과 열정을 믿");
            softly.assertThat(account.tagLine())
                    .isEqualTo("kr2");
        });
    }
}
