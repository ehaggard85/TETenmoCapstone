package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Transfer> list(int userId) {
        List<Transfer> listOfTransfers = new ArrayList<>();
        String sql = "SELECT transfer_amount FROM transfer " +
                "JOIN account ON account.transfer_id = transfer.transfer_id " +
                "JOIN tenmo_user ON tenmo_user.user_id = account.user_id " +
                "WHERE user_id = ?;";
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

        String sql = "INSERT INTO (sender, transfer_amount, receiver) " +
                "VALUES(?, ?, ?) RETURNING transfer_id;";
        Integer newId = jdbcTemplate.queryForObject(sql,
                Integer.class, transfer.getSender(),
                transfer.getTransfer_amount(), transfer.getReceiver());

        return getByTransferId(newId);
    }

    private Transfer mapRowToTransfer(SqlRowSet row) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(row.getInt("account_id"));
        transfer.setSender(row.getString("sender"));
        transfer.setReceiver(row.getString("receiver"));
        transfer.setTransfer_amount(row.getBigDecimal("transfer_amount"));


        return transfer;

    }

}
