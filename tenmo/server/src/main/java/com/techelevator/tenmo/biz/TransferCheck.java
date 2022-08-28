package com.techelevator.tenmo.biz;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.math.BigDecimal;

@Component
public class TransferCheck implements TransferCheckInterface {
    @Autowired
    UserDao userDao;
    @Autowired
    TransferDao transferDao;
    @Autowired
    AccountDao accountdao;


    @Override
    public boolean accountGreaterThanZero(int accountId) {

        return accountdao.getAccount(accountId).getBalance().compareTo(BigDecimal.ZERO) > 0;
        // this (above) compareTo() checks that [x.compareTo(y) <operator> 0]
        // so, in the above: I'm checking that the balance of the particular accountId
        // is > the constant BigDecimal.ZERO
        // the following ">" is my operator and the "0"
        // is required to use that -> x.compareTo(y) statement
    }


    // Check the getBalance from my accountId
    // I want to compareTo(BigDecimal transferAmount) which matches that accountId
    // and then check that the balance is > the transferAmount

    @Override
    public boolean balanceGreaterThanTransfer(int accountId, BigDecimal transferAmount) {
        return accountdao.getAccount(accountId).getBalance().compareTo(transferAmount) >= 0;
    }

    //sender != receiver
    @Override
    public boolean senderNotReceiver(int senderAccountId, int receiverAccountId) {
        return senderAccountId != receiverAccountId;
    }

    // check that the passed-in transferAmount is > 0
    @Override
    public boolean transferAmountPositive(BigDecimal transferAmount) {
        return transferAmount.compareTo(BigDecimal.ZERO) > 0;
    }
}


