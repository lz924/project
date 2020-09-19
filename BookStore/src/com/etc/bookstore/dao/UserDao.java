package com.etc.bookstore.dao;

import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Role;
import com.etc.bookstore.entity.Users;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //    用户登录
    public Users login(String name, String pwd);
//    添加用户
    public int addUser(Users u) throws SQLException;
//    添加角色信息
    public int addRole(Role role) throws SQLException;
//    查询用角色
    public List<Role> getUserRole() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;
}
