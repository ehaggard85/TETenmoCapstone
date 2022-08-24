package com.techelevator.tenmo.dao;

import java.util.List;

public interface AccountDao {


    AccountDao getBalance(int id);

    List<AccountDao> getTransfers(int accountId);



}
