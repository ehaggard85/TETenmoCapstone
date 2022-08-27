package com.techelevator.tenmo.biz;

public class TransferCheck implements TransferCheckInterface{

    //user.getbalance > 0
    @Override
    public boolean accountGreaterThanZero() {
        boolean success = true;
        if(userDao.getbalance <= 0){
            success = false;
            System.out.println("Insufficient account balance");
        }
        return success;
    }

    //user.getbalance > sender.transfer_amount
    @Override
    public boolean balanceGreaterThanTransfer() {
        return false;
    }

    //sender != receiver
    @Override
    public boolean senderNotreceiver() {
        return false;
    }
    // sender.transfer_amount > 0
    @Override
    public boolean transferAmountPositive() {
        return false;
    }
}


