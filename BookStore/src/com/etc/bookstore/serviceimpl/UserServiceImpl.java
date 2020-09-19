package com.etc.bookstore.serviceimpl;

import com.etc.bookstore.dao.UserDao;
import com.etc.bookstore.daoimpl.UserDaoImpl;
import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Role;
import com.etc.bookstore.entity.Users;
import com.etc.bookstore.service.UserService;
import com.etc.bookstore.util.Log;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    /**
     * 登录用户
     * @param pwd
     * @return
     */
    @Override
    public Users login(String name, String pwd) {
        UserDao dao = new UserDaoImpl();
        Users users = null;
        try {
            users = dao.login(name, pwd);
        } finally {
//            关闭资源
            ((UserDaoImpl) dao).closeDB();
        }
        return users;
    }


    /**
     * 注册：添加用户及角色
     * @return
     */
    @Override
    public int regist(Users users) throws SQLException {
        UserDao dao = new UserDaoImpl();
        int no = 0;
        try {
//        打开事务
            ((UserDaoImpl)dao).openTransaction();
//            添加角色信息
            int ro = dao.addRole(users.getRole_no());
            users.getRole_no().setRole_no(ro);
//            添加用户信息
            no = dao.addUser(users);
//        提交事务
            ((UserDaoImpl)dao).commitTransaction();
        }catch (Exception e) {
//        回滚事务
            ((UserDaoImpl)dao).rollbackTransaction();
//            添加日志
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }finally {
//        关闭资源
            ((UserDaoImpl)dao).closeDB();
        }
        return no;
    }

//    查询用户及角色
    public List<Role> getUserRole(){
        UserDao dao = new UserDaoImpl();
        List<Role> roles = null;
        try {
            roles = dao.getUserRole();
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl) dao).closeDB();
        }
        return roles;
    }

}
