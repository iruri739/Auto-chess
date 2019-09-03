package com.accenture.huaweigroup.module.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;
    private String name;
    private String pwd;
    private String avatar;
    private String nickName;

    public User() {
        super();
    }

    public User(String name, String pwd, String avatar, String nickName) {
        super();
        this.name = name;
        this.pwd = pwd;
        this.avatar = avatar;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
