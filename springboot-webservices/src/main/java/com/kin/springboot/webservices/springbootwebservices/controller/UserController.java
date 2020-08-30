package com.kin.springboot.webservices.springbootwebservices.controller;

import com.kin.springboot.webservices.springbootwebservices.entity.User;
import com.kin.springboot.webservices.springbootwebservices.exception.UserNotFoundException;
import com.kin.springboot.webservices.springbootwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = service.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        Optional<User> user = service.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("id:"+id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        User savedUser = service.save(user);
        return savedUser;
    }
}
