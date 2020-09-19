package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private Integer user_no;
    private Role role_no;
    private String user_name;
    private String user_pwd;
    private String user_email;
    private List<Orde> ordes;

    public Users(String no) {
        ordes = new ArrayList<>();
    }

    public Users() {
        ordes = new ArrayList<>();
    }

    public Users(String user_name, String user_pwd, String user_email, Role role_no) {
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_email = user_email;
        this.role_no = role_no;
        ordes = new ArrayList<>();
//        将此用户添加到role
        this.role_no.getUsers().add(this);
    }


    public List<Orde> getOrdes() {
        return ordes;
    }

    public void setOrdes(List<Orde> ordes) {
        this.ordes = ordes;
    }

    public Integer getUser_no() {
        return user_no;
    }

    public Role getRole_no() {
        return role_no;
    }

    public void setRole_no(Role role_no) {
        this.role_no = role_no;
    }

    public void setUser_no(Integer user_no) {
        this.user_no = user_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_no=" + user_no +
                ", role_no=" + role_no +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_email='" + user_email + '\'' +
                ", ordes=" + ordes +
                '}';
    }
}
