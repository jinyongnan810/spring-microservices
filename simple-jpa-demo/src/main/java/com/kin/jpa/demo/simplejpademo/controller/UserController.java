package com.kin.jpa.demo.simplejpademo.controller;

import com.kin.jpa.demo.simplejpademo.entity.User;
import com.kin.jpa.demo.simplejpademo.service.UserDaoService;
import com.kin.jpa.demo.simplejpademo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        long id = service.insert(user);
        return user;
    }
    @PostMapping("/userrepo")
    public User createUserWithRepo(@RequestBody User user){
        userRepo.save(user);
        return user;
    }
    @GetMapping("/users")
    public List<User> GetUsers(){
        List<User> all = userRepo.findAll();
        return all;
    }
}
