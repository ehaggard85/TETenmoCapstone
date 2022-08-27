package com.techelevator.tenmo.biz;

import java.math.BigDecimal;

public interface TransferCheckInterface {


    public boolean accountGreaterThanZero(int userId, int account);

    public boolean balanceGreaterThanTransfer(int userId, int account,BigDecimal transferAmount);

    public boolean senderNotreceiver(int userId);

    public boolean transferAmountPositive(BigDecimal transferAmount);
}
