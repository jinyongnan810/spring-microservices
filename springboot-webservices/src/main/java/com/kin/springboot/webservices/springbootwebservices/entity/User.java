package com.kin.springboot.webservices.springbootwebservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@ApiModel("User infos")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Size(min = 2,message = "Name should be longer than 2 characters.")
    @ApiModelProperty(notes = "Name should be longer than 2 characters.")
    private String name;
    @ApiModelProperty(notes = "Date should be a pasted date.")
    @Past(message = "Date should be a pasted date.")
    private Date birthDate;
    @JsonIgnore// to hide password in response
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Post>posts;

    protected User(){}

    public User(@Size(min = 2, message = "Name should be longer than 2 characters.") String name, @Past(message = "Date should be a pasted date.") Date birthDate, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public List<Post> getPosts() {
        return posts;
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
