package com.kin.springboot.webservices.springbootwebservices.controller;

import com.kin.springboot.webservices.springbootwebservices.entity.Post;
import com.kin.springboot.webservices.springbootwebservices.entity.User;
import com.kin.springboot.webservices.springbootwebservices.exception.PostNotFoundException;
import com.kin.springboot.webservices.springbootwebservices.exception.UserNotFoundException;
import com.kin.springboot.webservices.springbootwebservices.service.PostService;
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
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("id:"+id);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        User savedUser = userService.save(user);
        return savedUser;
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            userService.deleteById(id);
            return;
        }
        throw new UserNotFoundException("id:"+id);
    }
    @GetMapping("/hello")
    public String hello(){
        return messageSource.getMessage("hello",null, LocaleContextHolder.getLocale());
    }

    @PostMapping("/users/{id}/posts")
    public Post createPost(@PathVariable Long id,@RequestBody Post post){
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id:"+id);
        }
        User user = userOptional.get();
        post.setUser(user);
        postService.save(post);
        return post;
    }
    @GetMapping("/users/{id}/posts")
    public List<Post> getUsersPosts(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id:"+id);
        }
        User user = userOptional.get();
        return user.getPosts();
    }
    @GetMapping("/users/{id}/posts/{postId}")
    public Post getUsersPosts(@PathVariable Long id,@PathVariable Long postId){
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id:"+id);
        }
        Optional<Post> postOptional = postService.findById(postId);
        if(!postOptional.isPresent()){
            throw new PostNotFoundException("id:"+postId);
        }
        return postOptional.get();
    }
    @DeleteMapping("/users/{id}/posts/{postId}")
    public void deletePosts(@PathVariable Long id,@PathVariable Long postId){
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id:"+id);
        }
        Optional<Post> postOptional = postService.findById(postId);
        if(!postOptional.isPresent()){
            throw new PostNotFoundException("id:"+postId);
        }
        postService.delete(postOptional.get());
    }

}
