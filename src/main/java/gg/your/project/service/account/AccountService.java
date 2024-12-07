package gg.your.project.service.account;

import gg.your.project.domain.account.Account;
import gg.your.project.domain.account.AccountRepository;
import gg.your.project.domain.account.SearchFullName;
import gg.your.project.service.account.dto.RiotAccountDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public Optional<Account> findBySearchFullName(final SearchFullName fullName) {
        return accountRepository.findBySearchFullName(fullName);
    }

    public Account updateOrSave(final RiotAccountDto riotAccountDto) {
        Optional<Account> findAccount = accountRepository.findByPuuid(riotAccountDto.puuid());
        if (findAccount.isPresent()) {
            Account account = findAccount.get();
            account.update(riotAccountDto.puuid(), riotAccountDto.gameName(), riotAccountDto.tagLine());
            return account;
        }
        Account account = Account.from(riotAccountDto.puuid(), riotAccountDto.gameName(), riotAccountDto.tagLine());
        return accountRepository.save(account);
    }
}
