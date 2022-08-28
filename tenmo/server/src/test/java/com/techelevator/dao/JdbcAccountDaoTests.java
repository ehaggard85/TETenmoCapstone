package com.techelevator.dao;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcAccountDaoTests extends BaseDaoTests{

    private JdbcAccountDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcAccountDao(jdbcTemplate);
    }
    //testing current userId yields users accountId
    @Test
    public  void getAccountByUserId(){

       int userAccountId = sut.getAccountByUserId(1001).getAccountId();
       int expectedAccountId = 2001;
        Assert.assertEquals(expectedAccountId, userAccountId);
    }

    //Why did we need a wrapper Class?
    @Test
    public  void getAccountByUserIdNull(){

        Account actualUserId = sut.getAccountByUserId(4500);
        Account expectedAccount = null;
        Assert.assertNull(String.valueOf(actualUserId), null);
    }


    @Test
    public void getBalanceByAccountIdTest(){

        List<Account> balance = sut.getBalance(2001);
        List<Account> expectedBalance = new ArrayList<>(1);

        Assert.assertEquals(balance, expectedBalance);
    }



}
