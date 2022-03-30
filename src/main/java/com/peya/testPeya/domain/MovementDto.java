package com.peya.testPeya.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MovementDto {
    private String action;
    private BigDecimal amount;
    @JsonProperty("account_id")
    private Long accountId;

    public MovementDto() {

    }

    /**
     * Constructor with params.
     * @param action
     * @param amount
     * @param accountId
     */
    public MovementDto(String action, BigDecimal amount, Long accountId) {
        this.action = action;
        this.amount = amount;
        this.accountId = accountId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
