package com.etc.studentsystem.daoimpl;

import com.etc.studentsystem.entity.Data;
import com.etc.studentsystem.util.JudgeNo;


public class DataDaoImpl {
//    块
    int i = 2;
    static Data[] data ;
    {
//        System.out.println("我是一个普通块");
    }
    static{
        data = new Data[10];
//        System.out.println("我是一个静态块");
        data[0] = new Data("xx",10) ;
        data[1] = new Data("hh",20) ;

    }

    public int getNo(){
        return JudgeNo.judge();
    }

//    登录功能
//    public Student login(String name, int pwd) {
//        Student stu = null;
//        if ("hello".equals(name) && pwd == 111)
//           stu = new Student();//当用户名和密码都正确，创建对象，即当前对象不为空
//        return stu;
//    }
    public boolean login(Data data) {
//        当参数少的时候传参数，多的时候传对象
//        对象作为参数可以在获取用户信息后将信息存储到Student对象中，然后传递对象
//        需要在持久层获取时可以使用对象调用get方法获值
        if ("hello".equals(data.getName()) && 111 == data.getPwd()) {//当用户名和密码都正确，创建对象，即当前对象不为空
            return true;
        } else {
            return false;
        }
    }
//注册功能
    public void regist(Data da) {
//        注册功能其实就是用户输入的对象信息存储到数组中
//        因为数组是按照位置进行存储，所以我们只需要得到当前下标位置进行存储

        if (i <= 9) {
//            我们一般遇到对象操作的时候都要进行一个判空操作
            if (da !=null) {
                data[i] = da;
                //添加一条信息，则下标需要下移
                System.out.println("注册成功...");
                i++;
            }
        } else {
            System.out.println("对不起班级人数已满！！");
        }
    }
}
