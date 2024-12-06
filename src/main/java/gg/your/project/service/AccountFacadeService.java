package gg.your.project.service;

import gg.your.project.domain.account.Account;
import gg.your.project.domain.account.SearchFullName;
import gg.your.project.service.account.RiotAccountProvider;
import gg.your.project.service.account.AccountService;
import gg.your.project.service.account.dto.RiotAccountDto;
import gg.your.project.service.account.dto.RiotIdDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFacadeService {

    private final AccountService accountService;
    private final RiotAccountProvider riotAccountProvider;

    public Account findOrSaveAccount(final String fullName) {
        SearchFullName searchFullName = SearchFullName.from(fullName);
        Optional<Account> findAccount = accountService.findBySearchFullName(searchFullName);

        if (findAccount.isPresent()) {
            return findAccount.get();
        }
        RiotAccountDto riotAccount = riotAccountProvider.findAccount(RiotIdDto.from(searchFullName.getSearchFullName()));
        Account account = new Account(riotAccount.puuid(), riotAccount.gameName(), riotAccount.tagLine(), searchFullName);
        return accountService.save(account);
    }
}
