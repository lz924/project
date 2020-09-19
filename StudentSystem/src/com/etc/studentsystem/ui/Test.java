package com.etc.studentsystem.ui;

import com.etc.studentsystem.entity.Data;
import com.etc.studentsystem.serviceimpl.DataServiceImpl;
import com.etc.studentsystem.util.JudgeNo;

import java.util.Scanner;

public class Test {
    //    获取一个数字
    public void getNo() {
        DataServiceImpl service = new DataServiceImpl();
        System.out.println("no=" + service.getNo());
    }

    //    登录功能
//    public void login(){
//        System.out.println("请输入用户名：");
//        String name = "hello";
//        System.out.println(name);
//        System.out.println("请输入密码：");
//        int pwd = 111;
//        System.out.println(pwd);
//        DataServiceImpl dataService = new DataServiceImpl();
////        基本数据类型与引用数据类型的string做参数，对象做返回值
//        Data data = dataService.login(name, pwd);
//
//        if (stu == null){
//            System.out.println("登录失败，用户名或密码错误...");
//        }else{
//            System.out.println("登录成功，欢迎进入系统...");
//        }
//    }
//        实现登录用对象做参数，布尔类型做返回值
    public void login(Data data) {
        System.out.println("请输入用户名：");
        String name = "hello";
        data.setName(name);
        System.out.println(data.getName());
        System.out.println("请输入密码：");
       int pwd = 111;
        data.setPwd(pwd);
        System.out.println(data.getPwd());
        DataServiceImpl dataService = new DataServiceImpl();
//        基本数据类型与引用数据类型的string做参数，对象做返回值
        boolean flag = dataService.login(data);
        if (flag ) {
            System.out.println("登录成功，欢迎进入系统...");
        } else {
            System.out.println("登录失败，用户名或密码错误...");
        }
    }

//    注册功能

    public void regist(){
        System.out.println("请输入用户名：");
        Scanner input = new Scanner(System.in);
        Data data = new Data();
        data.setName(input.next());
        System.out.println("请输入密码：");
        data.setPwd(JudgeNo.judge());
        DataServiceImpl service = new DataServiceImpl();
        service.regist(data);


    }
    public static void main(String[] args) {
//        程序入口，即只是一个入口的调用
//        new Test().getNo();
//        测试登录
//        new Test().login();
       Data d = new Data();
        new Test().regist();
    }
}
