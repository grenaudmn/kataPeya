package com.peya.testPeya.Repository;

import com.peya.testPeya.domain.AccountDto;
import com.peya.testPeya.domain.MovementDto;

import java.util.List;

public interface AccountRepository {
    AccountDto getAccount(Long accountId);
    AccountDto updateAccount(AccountDto account);
    List<MovementDto> retrieveHistory(Long accountId);
}
