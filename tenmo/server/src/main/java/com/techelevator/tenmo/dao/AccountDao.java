package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.util.List;

public interface AccountDao {


    List<Account> getBalance(int userId);

    Account getAccount(int accountId);






}
