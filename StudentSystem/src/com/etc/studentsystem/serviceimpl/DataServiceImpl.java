package com.etc.studentsystem.serviceimpl;

import com.etc.studentsystem.daoimpl.DataDaoImpl;
import com.etc.studentsystem.entity.Data;


public class DataServiceImpl {

    DataDaoImpl dao = new DataDaoImpl();
//    得到一个数字
    public int getNo(){
//        在service中需要向dao层调用方法得到数据，所以需要先创建一个dao层
        return  dao.getNo();
    }
//    登录功能
//    public Student login(String name, int pwd){
//
//        return daoimpl.login(name ,pwd);
//    }
    public boolean login(Data data){
        return dao.login(data);
    }

//    实现注册功能
    public void regist(Data data){
         dao.regist(data);
    }
}
