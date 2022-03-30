package com.peya.testPeya.services;

import com.peya.testPeya.Repository.AccountRepository;
import com.peya.testPeya.domain.AccountDto;
import com.peya.testPeya.domain.MovementDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountService implements AccountRepository {

    @Override
    public AccountDto getAccount(Long accountId) {
        return new AccountDto(new BigDecimal(2000), accountId);
    }

    @Override
    public AccountDto updateAccount(AccountDto account) {
        return account;
    }

    @Override
    public List<MovementDto> retrieveHistory(Long accountId) {
        List<MovementDto> movementDtos = new ArrayList<>();

        movementDtos.add(new MovementDto("add", new BigDecimal(120), accountId));
        movementDtos.add(new MovementDto("extract", new BigDecimal(3000), accountId));
        movementDtos.add(new MovementDto("add", new BigDecimal(5000), accountId));

        return movementDtos;
    }
}
