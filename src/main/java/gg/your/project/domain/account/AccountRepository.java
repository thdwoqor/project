package gg.your.project.domain.account;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findBySearchFullName(final SearchFullName searchFullName);
    Optional<Account> findByPuuid(final String puuid);
}
