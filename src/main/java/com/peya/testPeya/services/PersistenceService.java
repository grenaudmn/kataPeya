package com.peya.testPeya.services;

import com.peya.testPeya.Repository.AccountRepository;
import com.peya.testPeya.Repository.MovementRepository;
import com.peya.testPeya.domain.AccountDto;
import com.peya.testPeya.domain.MovementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistenceService{

    @Autowired
    MovementService movementService;

    @Autowired
    AccountRepository accountRepository;

    PersistenceService(MovementService theMovementService, AccountRepository theAccountRepository) {
        movementService = theMovementService;
        accountRepository = theAccountRepository;
    }

    /**
     * Updates the account information with the given data.
     * @param accountData the account data provided.
     * @param theAction
     * @return the updated account
     */
    public AccountDto update(AccountDto accountData, String theAction) {
        //get data db
        AccountDto actualAccount = accountRepository.getAccount(accountData.getAccountId());
        actualAccount.addAmount(accountData.getAmount());
        //update db
        AccountDto updatedAccount = accountRepository.updateAccount(actualAccount);
        movementService.insert(new MovementDto(theAction, accountData.getAmount(), accountData.getAccountId()));
        return updatedAccount;
    }
}
