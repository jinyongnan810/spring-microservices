package com.kin.springboot.webservices.springbootwebservices.service;

import com.kin.springboot.webservices.springbootwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User,Long> {

}
