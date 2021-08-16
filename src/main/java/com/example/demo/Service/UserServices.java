package com.example.demo.Service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserServices {

        public void addUser(UserDto userDto);
        public List<UserDto> getAllUsers();
        public void updateUser(UserDto userDto);
        public void deleteUser(Integer id);
    }


