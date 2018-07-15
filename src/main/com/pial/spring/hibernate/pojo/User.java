package com.pial.spring.hibernate.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int user_id;
    private String user_name;
    private String user_password;

    public User(int id, String name, String password) {
        this.user_id = id;
        this.user_name = name;
        this.user_password = password;
    }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }





}
