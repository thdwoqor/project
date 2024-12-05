package gg.your.project.infra.riotgames;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import gg.your.project.service.AccountProvider;
import gg.your.project.service.dto.AccountDto;
import gg.your.project.service.dto.RiotIdDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountClientTest {

    @Autowired
    private AccountProvider accountProvider;

    @Test
    void 라이엇_고유_id_를_조회_할_수_있다() {
        AccountDto account = accountProvider.findAccount(RiotIdDto.from("난 우리팀의 노력과 열정을 믿#kr2"));

        assertSoftly(softly -> {
            softly.assertThat(account.puuid())
                    .isEqualTo("jfgcPI2_9rOZRAcsgkSf56G4RA_cZHxNu4yUWkZaSnL_XZPDp7noFnrPsfg_ENcB8NsDTHQ_JZ2wjA");
            softly.assertThat(account.gameName())
                    .isEqualTo("난 우리팀의 노력과 열정을 믿");
            softly.assertThat(account.tagLine())
                    .isEqualTo("kr2");
        });
    }
}
