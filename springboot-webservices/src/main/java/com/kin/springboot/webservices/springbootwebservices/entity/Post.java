package com.kin.springboot.webservices.springbootwebservices.entity;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String desc;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post() {
    }

    public Post(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
