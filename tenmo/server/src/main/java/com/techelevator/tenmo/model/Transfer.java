package com.techelevator.tenmo.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Transfer {

private int transferId;

    @NotNull(message = "The Sender field cannot be left blank.")
private int sender;
    @NotNull(message = "The Receiver field cannot be left blank.")
private int receiver;
 //@DecimalMin(value = "1.0", message = "Transfer Amount must be at least $1.00.")
private BigDecimal transfer_amount;

// empty constructor
public Transfer(){}


    public Transfer(int transferId, int sender,
                    int receiver, BigDecimal transfer_amount)
    {
        this.transferId = transferId;
        this.sender = sender;
        this.receiver = receiver;
        this.transfer_amount = transfer_amount;
    }


    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int  sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int  receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(BigDecimal transfer_amount) {
        this.transfer_amount = transfer_amount;
    }




}
