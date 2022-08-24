package com.techelevator.tenmo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController {


    private TransferDao transferDao;

  public  TransferController(TransferDao transferDao){

      this.transferDao = transferDao;
  }



}


