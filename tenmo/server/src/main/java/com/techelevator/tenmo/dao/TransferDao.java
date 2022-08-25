package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {



    List<Transfer> list(int userId);

    Transfer getByTransferId(int transferId);







    Transfer sendTransfer(Transfer transfer);


}
