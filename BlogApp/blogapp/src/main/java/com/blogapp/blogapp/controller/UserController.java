package com.blogapp.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.blogapp.payloads.ApiResponse;
// import com.blogapp.blogapp.entities.User;
import com.blogapp.blogapp.payloads.UserDto;
import com.blogapp.blogapp.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Post create user
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserDto user) {
        UserDto dto = this.userService.createUser(user);
        return new ResponseEntity<> (new ApiResponse("User created successfully", true, dto), HttpStatus.CREATED);
    }
    
    // Get user
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        UserDto dto = this.userService.getUserById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // Put/Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer id) {
        UserDto dto = this.userService.updateUser(userDto, id);
        return new ResponseEntity<>(new ApiResponse("User Updated Successfully", true, dto), HttpStatus.OK);
    }

    // Path 
    @PatchMapping("/patch/{id}")
    public ResponseEntity<ApiResponse> patchUser(@Valid @RequestBody UserDto userdto, @PathVariable Integer id){
        UserDto dto = this.userService.patchUser(userdto, id);
        return new ResponseEntity<>(new ApiResponse("Success", true, dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        this.userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true, null), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllUsers(
        @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
    ){
        List<UserDto> list = this.userService.getAllUsers(pageNumber, pageSize);
        return new ResponseEntity<>(new ApiResponse("Users Retrieved Successfully", true, list), HttpStatus.OK);
    }
}
