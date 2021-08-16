package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addNewUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @GetMapping
    public List<UserDto> getAll(){
       return userService.getAllUsers();
    }
}
