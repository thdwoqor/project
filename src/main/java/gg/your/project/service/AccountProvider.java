package gg.your.project.service;

import gg.your.project.service.dto.AccountDto;
import gg.your.project.service.dto.RiotIdDto;

public interface AccountProvider {

    AccountDto findAccount(final RiotIdDto riotIdDto);
}
