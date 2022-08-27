package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.biz.TransferCheck;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.dao.UserDaoDTO;
import com.techelevator.tenmo.exception.MessageNotGreaterThanZero;
import com.techelevator.tenmo.exception.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserDaoDTO userDaoDTO;
    private TransferCheck transferCheck;

  public  TransferController(TransferDao transferDao, UserDao userDao, UserDaoDTO userDaoDTO){

      this.transferDao = transferDao;
      this.userDao = userDao;
      this.userDaoDTO = userDaoDTO;
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET )
    public Transfer getByTransferId(@PathVariable ("id")
       Integer transferId) throws TransferNotFoundException {

        return transferDao.getByTransferId(transferId);
    }


    @RequestMapping(path = "/activeUsers", method = RequestMethod.GET)
    public List<UserDTO> getActiveUsers(Principal principal) throws TransferNotFoundException{

      return userDaoDTO.getAllUsers(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Transfer sendTransfer(@Valid @RequestBody Transfer transfer, Principal principal)
            throws TransferNotFoundException {
//        Remember: Postman *is* the Client
        transfer.setSender(userDao.findIdByUsername(principal.getName()));
        int sendersId = transfer.getSender();
        int receiversId = transfer.getReceiver();

        if (transferCheck.accountGreaterThanZero(sendersId)) {
            return transferDao.sendTransfer(transfer);
        } else throw new MessageNotGreaterThanZero("Yo, you have no money bro!");


    }
        @RequestMapping(path = "/allUserTransfers", method = RequestMethod.GET)
    public List<Transfer> list(Principal principal) throws TransferNotFoundException {

      return transferDao.list(userDao.findIdByUsername(principal.getName()));
        }

}


