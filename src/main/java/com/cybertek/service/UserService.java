package com.cybertek.service;

import com.cybertek.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
public interface UserService extends CrudService<UserDTO, String>{
    //save
    //findBy user by username
    //give me all user list

//    UserDTO save(UserDTO user);
//    UserDTO findByUserID(String username);
//    List<UserDTO> findAll();
//    void delete(UserDTO user);
//    void deleteByUserId(String username);
    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();
}
