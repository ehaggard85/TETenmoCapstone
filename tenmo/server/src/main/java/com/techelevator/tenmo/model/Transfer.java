package com.techelevator.tenmo.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Transfer {

private int transferId;

    @NotBlank(message = "The Sender field cannot be left blank.")
private String sender;
    @NotBlank(message = "The Receiver field cannot be left blank.")
private String receiver;
    @DecimalMin(value = "1.0", message = "Transfer Amount must be at least $1.00.")
private BigDecimal transfer_amount;

// empty constructor
public Transfer(){}


    public Transfer(int transferId, String sender,
                    String receiver, BigDecimal transfer_amount)
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(BigDecimal transfer_amount) {
        this.transfer_amount = transfer_amount;
    }




}
