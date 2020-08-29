package com.kin.jpa.demo.simplejpademo.service;

import com.kin.jpa.demo.simplejpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
