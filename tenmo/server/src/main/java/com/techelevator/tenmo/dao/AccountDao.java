package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.util.List;

public interface AccountDao {


    Account getBalance(int userId);

    List<Account> getTransfers(int accountId);



}
