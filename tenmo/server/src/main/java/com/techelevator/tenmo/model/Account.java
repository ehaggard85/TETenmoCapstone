package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {

    private int accountId;

    private BigDecimal balance;

    // empty constructor
    public Account() {
    }


    public Account(int accountId, BigDecimal balance) {
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
