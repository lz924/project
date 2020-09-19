package com.etc.bookstore.daoimpl;

import com.etc.bookstore.dao.UserDao;
import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Role;
import com.etc.bookstore.entity.Users;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    /**
     * 登录用户
     * @return
     */
    @Override
    public Users login(String name, String pwd) {
        Users users = null;
        try {
            openDB();
//            当sql中有参数的时候需要使用？占位符来代替变量的值
            String sql = "select * from user where user_name = ? and user_pwd = ? ;";
//            sql的预编译
            preparedStatement = connection.prepareStatement(sql);
//            当有占位符的时候需要处理预编译的对象
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pwd);
//            执行sql语句，返回值为一个结果集
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                users = new Users();
                Integer s = resultSet.getInt("user_no");
                String p = resultSet.getString("user_pwd");
                users.setUser_no(s);
                users.setUser_pwd(p);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //关闭资源
            closeDB();
        }
        return users;
    }

    /**
     * 用户
     * @param u
     * @return
     * @throws SQLException
     */
    @Override
    public int addUser(Users u) throws SQLException {
        String sql = "insert into user(role_no,user_name,user_pwd,user_email) value(?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,u.getRole_no().getRole_no());
        preparedStatement.setString(2,u.getUser_name());
        preparedStatement.setString(3,u.getUser_pwd());
        preparedStatement.setString(4,u.getUser_email());
        return preparedStatement.executeUpdate();
    }

    /**
     * 角色
     * @param role
     * @return
     * @throws SQLException
     */
    @Override
    public int addRole(Role role) throws SQLException {
        String sql = "insert into role(role_name) value(?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,role.getRole_name());
//        执行SQL语句
        preparedStatement.executeUpdate();
        sql = "select role_no from role where role_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,role.getRole_name());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 查询用户角色
     * @return
     */
    @Override
    public List<Role> getUserRole() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "select * from user as u inner join role as r on u.role_no = r.role_no";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        List<Role> roles = new ArrayList<>();
        while(resultSet.next()){
            Role role = new Role();
            role.setRole_no(resultSet.getInt(2));
            role.setRole_name(resultSet.getString(7));
//            String user_name, String user_pwd, String user_email,Role role_no
            Users users = new Users(resultSet.getString(3), resultSet.getString(4),resultSet.getString(5), role);
            roles.add(role);
        }
        return roles;
    }
}
