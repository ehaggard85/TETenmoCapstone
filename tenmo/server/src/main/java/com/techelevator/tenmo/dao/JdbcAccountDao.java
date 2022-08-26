package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcAccountDao implements AccountDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();


    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Account> getBalance(int userId) {
        List<Account> balance = new ArrayList<>();
        String sql = "SELECT user_id, account_id, balance FROM Account " +
                "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            Account account = mapRowToAccount(results);
            balance.add(account);
        }

        return balance;
    }

    public Account mapRowToAccount(SqlRowSet row) {
        Account account = new Account();
        account.setUserId(row.getInt("user_id"));
        account.setAccountId(row.getInt("account_id"));
        account.setBalance(row.getBigDecimal("balance"));
        return account;
    }


}
