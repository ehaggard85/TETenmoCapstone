package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("isAuthenticated()")
@RestController("/transfer")
public class TransferController {


    private TransferDao transferDao;

  public  TransferController(TransferDao transferDao){

      this.transferDao = transferDao;
  }

  @RequestMapping(path = "", method = RequestMethod.GET )
    public Transfer getByTransferId(@PathVariable int transferId) throws TransferNotFoundException {

        return transferDao.getByTransferId(transferId);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
public Transfer sendTransfer(@RequestBody Transfer transfer) throws TransferNotFoundException {


      return transferDao.sendTransfer(transfer);
    }

}


