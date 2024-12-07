package gg.your.project.service.account;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import gg.your.project.domain.account.Account;
import gg.your.project.domain.account.AccountRepository;
import gg.your.project.service.AccountFacadeService;
import gg.your.project.service.account.dto.RiotAccountDto;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void 닉네임을_변경한_경우_계정을_업데이트한다() {
        //given
        Account account = Account.from(
                "123",
                "난 우리팀의 노력과 열정을 믿",
                "kr2"
        );
        accountRepository.save(account);

        //when
        accountService.updateOrSave(new RiotAccountDto(
                "123",
                "닉네임 변경",
                "닉변"
        ));

        //than
        Account result = accountRepository.findByPuuid(
                "123").orElseThrow();

        Assertions.assertThat(result.getGameName()).isNotEqualTo(account.getGameName());
    }
}
