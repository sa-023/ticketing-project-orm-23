package com.company.service;

import com.company.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService <UserDTO,String> {

//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    List<UserDTO> findAll();
//    void delete(UserDTO user);
//    void deleteById(String username);

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();



}
