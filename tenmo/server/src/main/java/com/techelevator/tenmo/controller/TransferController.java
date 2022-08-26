package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/transfer")
public class TransferController {


    private TransferDao transferDao;
    private UserDao userDao;




  public  TransferController(TransferDao transferDao, UserDao userDao){

      this.transferDao = transferDao;
      this.userDao = userDao;
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET )
    public Transfer getByTransferId(@PathVariable ("id")
       Integer transferId) throws TransferNotFoundException {

        return transferDao.getByTransferId(transferId);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
public Transfer sendTransfer(@Valid @RequestBody Transfer transfer, Principal principal)
            throws TransferNotFoundException {
//        Remember: Postman *is* the Client
        transfer.setSender(userDao.findIdByUsername(principal.getName()));


      return transferDao.sendTransfer(transfer);
    }

        @RequestMapping(path = "/allUserTransfers", method = RequestMethod.GET)
    public List<Transfer> list(Principal principal) throws TransferNotFoundException {

      return transferDao.list(userDao.findIdByUsername(principal.getName()));
        }

}


