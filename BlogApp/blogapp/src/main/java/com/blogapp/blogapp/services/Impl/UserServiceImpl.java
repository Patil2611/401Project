package com.blogapp.blogapp.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto dto) {
        //  Auto-generated method stub

        if (userRepo.existsByEmail(dto.getEmail())) {
            throw new ResourceNotFoundException("Email already exists", "Email", dto.getEmail());
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
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
    public UserDto getUserByEmail(String email) {
        //  Auto-generated method stub
        User user = this.userRepo.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User", " id ", email));
        return this.userToDto(user);
    }

    @Override
    public UserDto patchUser(UserDto userDto, Integer id){
        User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(null, null, userDto));

        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }

        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        
        this.updateUser(userDto, id);
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers(Integer pageNumber, Integer pageSize) {
        //  Auto-generated method stub
        
        List<User> users = this.userRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        List<UserDto> dtoList = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    public UserDto userToDto(User user){
        // UserDto userDto = new UserDto();
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        // userDto.setId(user.getId());
        // userDto.setName(user.getName());
        // userDto.setEmail(user.getEmail());
        // userDto.setPassword(user.getPassword());
        // userDto.setAbout(user.getAbout());
        // userDto.setAddress(user.getAddress());
        return userDto;
    }

    public User dtoToUser(UserDto dto){
        // User user = new User();

        User user = this.modelMapper.map(dto, User.class);

        // user.setId(dto.getId());
        // user.setName(dto.getName());
        // user.setEmail(dto.getEmail());
        // user.setPassword(dto.getPassword());
        // user.setAbout(dto.getAbout());
        // user.setAddress(dto.getAddress());
        return user;
    }

    @Override
    public boolean isUserAndPasswordCorrect(String username, String password) {
        Optional<User> op = userRepo.findByEmail(username);

        if (op.isPresent()) {
            User user = op.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
    
}
