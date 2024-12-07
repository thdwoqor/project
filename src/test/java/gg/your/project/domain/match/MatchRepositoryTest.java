package gg.your.project.domain.match;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gg.your.project.domain.account.Account;
import gg.your.project.domain.account.SearchFullName;
import gg.your.project.service.AccountFacadeService;
import gg.your.project.service.MatchFacadeService;
import gg.your.project.service.dto.MatchResponse;
import gg.your.project.service.match.RiotMatchProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MatchRepositoryTest {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchFacadeService matchFacadeService;
    @MockBean
    private AccountFacadeService accountFacadeService;
    @MockBean
    private RiotMatchProvider riotMatchProvider;

    @Test
    void 최근_경기가_데이터베이스에_존재하지않은_경우_존재하지_않은_경기만_검색한다() {
        //given
        List<String> matchIds = new ArrayList<>(List.of(
                "KR_7393639370",
                "KR_7391497811"
        ));

        matchRepository.saveAll(List.of(
                MatchFixture.매치("KR_7391497811")
        ));

        when(accountFacadeService.findOrSaveAccount(anyString())).thenReturn(Account.from(
                "jfgcPI2_9rOZRAcsgkSf56G4RA_cZHxNu4yUWkZaSnL_XZPDp7noFnrPsfg_ENcB8NsDTHQ_JZ2wjA",
                "난 우리팀의 노력과 열정을 믿",
                "kr2"
        ));
        when(riotMatchProvider.findMatchAsync(anyString()))
                .thenReturn(CompletableFuture.completedFuture(MatchFixture.매치응답("KR_7393639370")));
        when(riotMatchProvider.findMatchIds(anyString(),anyInt()))
                .thenReturn(matchIds);


        //when
        matchFacadeService.findLastMatch("난 우리팀의 노력과 열정을 믿#kr2");

        //then
        verify(accountFacadeService,times(1)).findOrSaveAccount(eq("난 우리팀의 노력과 열정을 믿#kr2"));
        verify(riotMatchProvider,times(1)).findMatchAsync(eq("KR_7393639370"));
    }

    @Test
    void 최근_경기가_모두_데이터베이스에_존재하는_경우_API_요청없이_데이터베이스_값을_반환한다() {
        //given
        List<String> matchIds = new ArrayList<>(List.of(
                "KR_7391497816"
        ));

        matchRepository.saveAll(List.of(
                MatchFixture.매치("KR_7391497816")
        ));

        when(accountFacadeService.findOrSaveAccount(anyString())).thenReturn(Account.from(
                "jfgcPI2_9rOZRAcsgkSf56G4RA_cZHxNu4yUWkZaSnL_XZPDp7noFnrPsfg_ENcB8NsDTHQ_JZ2wjA",
                "난 우리팀의 노력과 열정을 믿",
                "kr2"
        ));
        when(riotMatchProvider.findMatchAsync(anyString()))
                .thenReturn(CompletableFuture.completedFuture(MatchFixture.매치응답("KR_7391497816")));
        when(riotMatchProvider.findMatchIds(anyString(),anyInt()))
                .thenReturn(matchIds);

        //when
        matchFacadeService.findLastMatch("난 우리팀의 노력과 열정을 믿#kr2");

        //then
        verify(accountFacadeService,times(1)).findOrSaveAccount(eq("난 우리팀의 노력과 열정을 믿#kr2"));
        verify(riotMatchProvider,times(0)).findMatchAsync(eq("KR_7391497816"));
    }
}
