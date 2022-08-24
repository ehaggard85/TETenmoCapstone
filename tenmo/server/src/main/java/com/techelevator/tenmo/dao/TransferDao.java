package com.techelevator.tenmo.dao;

import java.util.List;

public interface TransferDao {



    List<TransferDao> list();

    TransferDao getByTransferId(int transferId);

    TransferDao create(TransferDao transferDao);


    TransferDao sendTransfer(TransferDao transferDao);


}
