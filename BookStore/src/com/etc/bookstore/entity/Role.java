package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Integer role_no;
    private String role_name;
    private List<Users> users;

    public Role() {
        users = new ArrayList<>();
    }

    public Role(String role_name) {
        this.role_name = role_name;
        users = new ArrayList<>();
    }

    public Integer getRole_no() {
        return role_no;
    }

    public void setRole_no(Integer role_no) {
        this.role_no = role_no;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }


    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
