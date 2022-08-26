package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDaoDTO implements UserDaoDTO {

    JdbcTemplate jdbcTemplate;

    public JdbcUserDaoDTO(JdbcTemplate jdbcTemplate) {
     this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<UserDTO> getAllUsers(int userId) {
        List<UserDTO> users = new ArrayList<>();
        String sql = "SELECT user_id, username FROM tenmo_user WHERE user_id != ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
//            UserDTO userDTO = mapRowToUserDTO(results);
            UserDTO userDTO = mapRowToUserDTO(results);
            users.add(userDTO);
        }
        return users;
    }


    private UserDTO mapRowToUserDTO(SqlRowSet row){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(row.getInt("user_id"));
        userDTO.setUsername(row.getString("username"));
        return userDTO;
    }

}
