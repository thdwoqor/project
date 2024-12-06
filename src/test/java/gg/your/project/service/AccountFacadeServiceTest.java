package gg.your.project.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gg.your.project.domain.account.Account;
import gg.your.project.domain.account.SearchFullName;
import gg.your.project.service.account.AccountService;
import gg.your.project.service.account.RiotAccountProvider;
import gg.your.project.service.account.dto.RiotAccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AccountFacadeServiceTest {

    @Autowired
    private AccountFacadeService accountFacadeService;
    @Autowired
    private AccountService accountService;
    @MockBean
    private RiotAccountProvider riotAccountProvider;

    @Test
    void 기존_계정이_존재할_경우_RIOT_API_요청을_보내지_않는다() {
        //given
        Account account = new Account(
                "jfgcPI2_9rOZRAcsgkSf56G4RA_cZHxNu4yUWkZaSnL_XZPDp7noFnrPsfg_ENcB8NsDTHQ_JZ2wjA",
                "난 우리팀의 노력과 열정을 믿",
                "kr2",
                SearchFullName.from("난 우리팀의 노력과 열정을 믿#kr2")
        );
        accountService.save(account);

        //when
        accountFacadeService.findOrSaveAccount(account.getSearchFullName().getSearchFullName());
        verify(riotAccountProvider, never()).findAccount(any());
    }

    @Test
    void 기존_계정이_존재하지_않을경우_RIOT_API_요청을_보낸다() {
        //given
        when(riotAccountProvider.findAccount(any())).thenReturn(new RiotAccountDto(
                "FRYihI_yQXCJM0x9eM_lPVUAs4i59IfBM3ZnjRzj-rNbZQaMtrzG9pfHWJC3_hPrXvTmHeoVvvttvA",
                "Hide on bush",
                "KR1"
        ));

        //when
        accountFacadeService.findOrSaveAccount("Hide on bush#KR1");
        verify(riotAccountProvider, times(1)).findAccount(any());
    }
}
