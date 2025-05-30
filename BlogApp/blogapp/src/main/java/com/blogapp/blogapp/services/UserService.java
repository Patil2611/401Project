package com.blogapp.blogapp.services;

import java.util.List;

// import com.blogapp.blogapp.entities.User;
import com.blogapp.blogapp.payloads.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer id);
    void deleteUser(Integer id);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();

}
