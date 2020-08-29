package com.kin.jpa.demo.simplejpademo.service;

import com.kin.jpa.demo.simplejpademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional//each action is within a transaction
public class UserDaoService {
    @PersistenceContext
    private EntityManager entityManager;
    public long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
