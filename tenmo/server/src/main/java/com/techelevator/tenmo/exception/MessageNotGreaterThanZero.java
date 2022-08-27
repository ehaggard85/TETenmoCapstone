package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageNotGreaterThanZero extends RuntimeException {
    public MessageNotGreaterThanZero(String errorMsgZero) {
        super("Your Account is not greater than zero.");

    }

}
