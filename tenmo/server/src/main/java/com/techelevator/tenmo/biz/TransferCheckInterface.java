package com.techelevator.tenmo.biz;

public interface TransferCheckInterface {


    public boolean accountGreaterThanZero();

    public boolean balanceGreaterThanTransfer();

    public boolean senderNotreceiver();

    public boolean transferAmountPositive();
}
