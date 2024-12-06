package gg.your.project.service.account;

import gg.your.project.domain.account.Account;
import gg.your.project.domain.account.AccountRepository;
import gg.your.project.domain.account.SearchFullName;
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

    public Account save(final Account account) {
        return accountRepository.save(account);
    }
}
