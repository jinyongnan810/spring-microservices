package com.kin.springboot.webservices.springbootwebservices.controller;

import com.kin.springboot.webservices.springbootwebservices.entity.User;
import com.kin.springboot.webservices.springbootwebservices.exception.UserNotFoundException;
import com.kin.springboot.webservices.springbootwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private MessageSource messageSource;

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
    public User createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        return savedUser;
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Long id){
        Optional<User> user = service.findById(id);
        if(user.isPresent()){
            service.deleteById(id);
            return;
        }
        throw new UserNotFoundException("id:"+id);
    }
    @GetMapping("/hello")
    public String hello(){
        return messageSource.getMessage("hello",null, LocaleContextHolder.getLocale());
    }
}
