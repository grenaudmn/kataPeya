package com.peya.testPeya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peya.testPeya.Repository.AccountRepository;
import com.peya.testPeya.domain.AccountDto;
import com.peya.testPeya.domain.MovementDto;
import com.peya.testPeya.services.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/account")
public class PeyaBankController {

    @Autowired
    PersistenceService persistenceService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PeyaBankController(PersistenceService thePersistenceService, AccountRepository theAccountRepository, ObjectMapper theObjectMapper){
        persistenceService = thePersistenceService;
        accountRepository = theAccountRepository;
        objectMapper = theObjectMapper;
    }

    @PostMapping("/deposit")
    public AccountDto save(@RequestBody AccountDto accountData, @RequestParam String action){
        validateBody(accountData);
        return persistenceService.update(accountData, action);
    }


    @GetMapping("/history")
    public List<MovementDto> retrieve(@RequestParam("account_id") final Long accountId) {
        if(accountId==null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "INVALID_ACCOUNT_ID");
        }
        return accountRepository.retrieveHistory(accountId);
    }

    /**
     * Validates the information of the body.
     * @param accountData
     */
    private void validateBody(AccountDto accountData) {
        Assert.notNull(accountData, "EMPTY_BODY");
        Assert.isTrue(accountData.getAmount().compareTo(BigDecimal.valueOf(0)) > 0, "INVALID_AMOUNT");
        Assert.notNull(accountData.getAccountId(), "INVALID_ACCOUNT_ID");
    }

}
