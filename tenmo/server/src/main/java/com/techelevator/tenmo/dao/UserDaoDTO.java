package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserDTO;

import java.util.List;

public interface UserDaoDTO {

    List<UserDTO> getAllUsers(int userId);

}
