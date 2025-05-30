package com.blogapp.blogapp.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.blogapp.entities.User;
import com.blogapp.blogapp.exceptions.ResourceNotFoundException;
import com.blogapp.blogapp.payloads.UserDto;
import com.blogapp.blogapp.repository.UserRepo;
import com.blogapp.blogapp.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    

    @Override
    public UserDto createUser(UserDto dto) {
        //  Auto-generated method stub

        User user = dtoToUser(dto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        //  Auto-generated method stub
        User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " id ", id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        user.setAddress(userDto.getAddress());
        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        //  Auto-generated method stub
        User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", id));
        this.userRepo.delete(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        //  Auto-generated method stub
        
        User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " id ", id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        //  Auto-generated method stub
        
        List<User> users = this.userRepo.findAll();
        List<UserDto> dtoList = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        userDto.setAddress(user.getAddress());
        return userDto;
    }

    public User dtoToUser(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAbout(dto.getAbout());
        user.setAddress(dto.getAddress());
        return user;
    }
    
}
