package com.techelevator.tenmo.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Account {

    private int accountId;
    @DecimalMin(value = "0", message = "Balance cannot go below zero.")
    private int userId;
    private BigDecimal balance;

    // empty constructor
    public Account() {
    }


    public Account(int userId, int accountId, BigDecimal balance) {
        this.userId = userId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }



}
