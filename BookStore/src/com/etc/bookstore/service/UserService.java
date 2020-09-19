package com.etc.bookstore.service;

import com.etc.bookstore.entity.Role;
import com.etc.bookstore.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    //    登录用户
    public Users login(String name, String pwd);
    //    注册用户
    public int regist(Users users) throws SQLException;
    //    查询用角色
    public List<Role> getUserRole();
}
