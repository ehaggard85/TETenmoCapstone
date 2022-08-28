package com.techelevator.tenmo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.annotation.HttpConstraint;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageSenderIsReceiver extends RuntimeException{
    public MessageSenderIsReceiver(String errorMsg) {
        super("You cannot send money to yourself, sorry.");
    }


}
