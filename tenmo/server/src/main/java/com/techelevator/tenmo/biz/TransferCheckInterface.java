package com.techelevator.tenmo.biz;

import java.math.BigDecimal;

public interface TransferCheckInterface {


    public boolean accountGreaterThanZero(int account);

    public boolean balanceGreaterThanTransfer(int account,BigDecimal transferAmount);

    public boolean senderNotReceiver(int senderAccountId, int receiverAccountId);

    public boolean transferAmountPositive(BigDecimal transferAmount);

}
