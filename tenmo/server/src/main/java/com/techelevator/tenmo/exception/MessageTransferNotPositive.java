package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageTransferNotPositive extends RuntimeException{

public    MessageTransferNotPositive(String errorMsg){
    super("Your Transfer Amount is NOT positive.");
}
}
