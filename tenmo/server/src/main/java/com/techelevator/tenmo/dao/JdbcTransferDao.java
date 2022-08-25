package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {


     JdbcTemplate jdbcTemplate;

     public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
         this.jdbcTemplate = jdbcTemplate;
     }




    @Override
    public List<Transfer> list(int userId) {
        List<Transfer> listOfTransfers = new ArrayList<>();
        String sql = "SELECT transfer_id, sender, receiver, transfer_amount FROM transfer " +
                "JOIN account ON account.account_id = transfer.sender " +
                "JOIN tenmo_user ON tenmo_user.user_id = account.user_id " +
                "WHERE tenmo_user.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            listOfTransfers.add(transfer);
        }

        return listOfTransfers;
    }

    @Override
    public Transfer getByTransferId(int transferId) {
       Transfer transfer = null;
       String sql = "SELECT transfer_id, sender, transfer_amount, receiver " +
               "FROM transfer WHERE transfer_id = ?;";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);

        if (results.next()) {
            transfer = mapRowToTransfer(results);

        } return transfer;
    }


    @Override
    public Transfer sendTransfer(Transfer transfer) {
        Transfer newTransfer = new Transfer();
        String sql = "INSERT INTO transfer (sender, transfer_amount, receiver) " +
                "VALUES ((SELECT account_id FROM account WHERE user_id = ?), ?, (SELECT account_id FROM account WHERE user_id = ?)) RETURNING transfer_id;";
        System.out.println(transfer.getSender());
        System.out.println(transfer.getReceiver());
        System.out.println(transfer.getTransfer_amount());
        Integer newId = jdbcTemplate.queryForObject(sql,
                Integer.class, transfer.getSender(),
                transfer.getTransfer_amount(), transfer.getReceiver());

        return getByTransferId(newId);
    }

    private Transfer mapRowToTransfer(SqlRowSet row) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(row.getInt("transfer_id"));
        transfer.setSender(row.getInt("sender"));
        transfer.setReceiver(row.getInt("receiver"));
        transfer.setTransfer_amount(row.getBigDecimal("transfer_amount"));


        return transfer;

    }

}
