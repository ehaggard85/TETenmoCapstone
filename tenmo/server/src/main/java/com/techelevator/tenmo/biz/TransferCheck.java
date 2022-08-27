package com.techelevator.tenmo.biz;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import org.springframework.web.client.ResourceAccessException;

public class TransferCheck implements TransferCheckInterface{
UserDao userDao;
TransferDao transferDao;
AccountDao accountdao;

public TransferCheck (UserDao userDao, TransferDao transferDao, AccountDao accountDao){
    this.userDao = userDao;
    this.transferDao = transferDao;
    this.accountdao = accountDao;
}
    //user.getbalance > 0
    @Override
    public boolean accountGreaterThanZero(userId) {
        boolean success = true;
        if(accountdao.getBalance())


        return success;
    }

    //user.getbalance > sender.transfer_amount
    @Override
    public boolean balanceGreaterThanTransfer() {
        return false;
    }

    //sender != receiver
    @Override
    public boolean senderNotreceiver() {
        return false;
    }
    // sender.transfer_amount > 0
    @Override
    public boolean transferAmountPositive() {
        return false;
    }
}


