package com.kin.springboot.webservices.springbootwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Date birthDate;

    protected User(){}

    public User(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
