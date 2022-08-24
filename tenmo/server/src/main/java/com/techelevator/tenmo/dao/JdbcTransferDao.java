package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {
private JdbcTemplate jdbcTemplate;

    @Override
    public List<TransferDao> list() {
        return null;
    }

    @Override
    public TransferDao getByTransferId(int transferId) {
        return null;
    }

    @Override
    public TransferDao create(TransferDao transferDao) {
        return null;
    }

    @Override
    public TransferDao sendTransfer(TransferDao transferDao) {
        return null;
    }

    private Transfer mapRowToTransfer(SqlRowSet row) {
        Transfer transfer = new Transfer();
        

        return transfer;

    }

}
