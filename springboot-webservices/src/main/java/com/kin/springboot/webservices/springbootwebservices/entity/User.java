package com.kin.springboot.webservices.springbootwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Size(min = 2,message = "Name should be longer than 2 characters.")
    private String name;
    @Past(message = "Date should be a pasted date.")
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
