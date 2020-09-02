package com.kin.springboot.webservices.springbootwebservices.service;

import com.kin.springboot.webservices.springbootwebservices.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService  extends JpaRepository<Post,Long> {
}
