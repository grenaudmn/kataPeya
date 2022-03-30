package com.peya.testPeya.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountDto {
    private BigDecimal amount;
    @JsonProperty("account_id")
    private Long accountId;

    public AccountDto() {
    }

    public AccountDto(final BigDecimal theAmount, final Long theAccoundId) {
        amount = theAmount;
        accountId = theAccoundId;
    }

    public void addAmount(final BigDecimal theAmount) {
        amount = amount.add(theAmount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}

