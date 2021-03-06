package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity @Table(name = "ls_user")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String avatarurl;
    private String avataruuid;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getAvataruuid() {
        return avataruuid;
    }

    public void setAvataruuid(String avataruuid) {
        this.avataruuid = avataruuid;
    }
}