package com.etc.studentsystem.ui;


import com.etc.studentsystem.entity.Student;
import com.etc.studentsystem.entity.StudentRole;
import com.etc.studentsystem.service.StudentService;
import com.etc.studentsystem.serviceimpl.ListServiceImpl;
import com.etc.studentsystem.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static com.sun.deploy.net.UpdateTracker.clear;

public class Menu extends LoginUI {
//        创建一个class对象
//    Class c = ListServiceImpl.class;
//    //    创建StudentService对象
//    ListServiceImpl ss;
//
//    {
//        try {
//            ss = (ListServiceImpl) c.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

////    创建一个class对象
//    Class c = StudentReflectServiceImpl.class;
//    //    创建StudentService对象
//    StudentReflectServiceImpl ss;
//
//    {
//        try {
//            ss = (StudentReflectServiceImpl) c.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    //            StudentService ss = new StudentServiceImpl();
//    StudentService ss = new SetServiceImpl();
    static StudentService ss = new ListServiceImpl();
    //    StudentService ss = new MapServiceImpl();
    static Scanner sc = new Scanner(System.in);
    Class cc = Student.class;
    //    Student student;
    static Student student;

    {
        try {
//            student = (Student) cc.newInstance();
            student = (Student) cc.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static RegistUI registUI;
    /*
        系统界面
     */
    public static void studentMenu(Student student) {
        System.out.println("---------------欢迎进入学生管理系统-------------");
//        设计需要实现的功能模块
        System.out.println("---------- 1、添加学生信息----------");
        System.out.println("---------- 2、查看学生信息----------");
        System.out.println("---------- 3、修改学生信息----------");
        System.out.println("---------- 4、删除学生信息----------");
        System.out.println("---------- 5、随机学生点名----------");
        System.out.println("---------- 6、退出学生系统----------");
        studentSelect(student);
//        调用进入系统后的操作菜单选择
    }

    public static void studentMenu1(Student student) {
        System.out.println("---------------欢迎进入学生管理系统-------------");
//        设计需要实现的功能模块
        System.out.println("---------- 1、添加学生信息----------");
        System.out.println("---------- 2、查看学生信息----------");
        System.out.println("---------- 3、修改学生信息----------");
        System.out.println("---------- 4、退出学生系统----------");
        studentSelect(student);
//        调用进入系统后的操作菜单选择
    }

    public static void studentMenu2(Student student) {
        System.out.println("---------------欢迎进入学生管理系统-------------");
//        设计需要实现的功能模块
        System.out.println("---------- 1、查看学生信息----------");
        System.out.println("---------- 2、退出学生系统----------");
        studentSelect(student);
//        调用进入系统后的操作菜单选择
    }

    /*
    进行选择
     */
//    主菜单选择
//    创建class对象
    Class<?> c1;

    {
        try {
//            加载类
            c1 = Class.forName("com.etc.studentsystem.ui.Menu");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void mainSelect() {
        System.out.println("请输入所选操作的对应序号...");
        Scanner scanner = new Scanner(System.in);
        int num = JudgeNo.judge();//调用判断输入是否是数字的静态方法
        switch (num) {
            case 1:

//                调用其他类
//                this.registMenu();
//              反射调用方法
                Method method = null;
                try {
//                    获取方法
                    method = c1.getMethod("registMenu");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
//                    调用方法
                    method.invoke(c1.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            case 2:// 选择登录，调用了登录方法
                new LoginUI();
                break;
            case 3:
                System.out.println("退出系统");
                System.exit(0);
                break;
            default:
                System.out.println("请输入1、2或3，其他无效...");
                new MainUI();
        }
    }

    //     学生菜单选择
    public static void studentSelect(Student student) {//进行学生系统功能的选择
        System.out.println("请输入进行操作的序号...");
        int num = JudgeNo.judge();
        if (StudentRole.班长.toString().equals(student.getRole())) {
            switch (num) {
                case 1:
                    System.out.println("添加学生信息");
                    addInfoB();//调用具体操作方法
                    break;
                case 2:
                    System.out.println("查看学生信息");
                    fingInfo();
                    break;
                case 3:
                    System.out.println("修改学生信息");
                    updateInfo();
                    break;
                case 4:
                    System.out.println("删除学生信息");
                    deleteInfo();
                    break;
                case 5:
                    System.out.println("随机学生点名");
                    getSname();
                    break;
                case 6:
                    System.out.println("退出学生管理系统...");
                    new MainUI();
                    break;
                default:
                    System.out.println("请输入数字（1-5）!!");
                    studentSelect(student);
            }
        } else if (StudentRole.组长.toString().equals(student.getRole())) {
            switch (num) {
                case 1:
                    System.out.println("添加学生信息");
                    addInfo();//调用具体操作方法
                    break;
                case 2:
                    System.out.println("查看学生信息");
                    fingInfo();
                    break;
                case 3:
                    System.out.println("修改学生信息");
                    updateInfo();
                    break;
                case 4:
                    System.out.println("退出学生管理系统...");
                   new MainUI();
                    break;
                default:
                    System.out.println("请输入数字（1-4）!!");
                    studentSelect(student);
            }
        } else if (StudentRole.学员.toString().equals(student.getRole())) {
            switch (num) {
                case 1:
                    System.out.println("查看学生信息");
                    fingInfo();
                    break;
                case 2:
                    System.out.println("退出学生管理系统...");
                    new MainUI();
                    break;
                default:
                    System.out.println("请输入数字（1-2）!!");
                    studentSelect(student);
            }
        }
    }

    /*
         操作
     */
    //    注册
    public static void registOperstion(Integer sno, String pwd, String pwd1) {
        Student stu = new Student();
        AddId.getId(stu);
        String password = JudgePwd.isPwd(pwd);
        if (password.equals(pwd)) {
            JudgePwd.gradePwd(pwd);
            if (pwd.equals(pwd1)) {//判断两次密码是否相同，若相同执行以下操作，不同则提示密码不同并重新注册
                stu.setSno(sno);
                stu.setPwd(pwd);
                stu.setRole(StudentRole.学员.toString());
                String result = ss.regist(sno, stu);
                if (result.equals("注册成功...")) {
                    System.out.println("注册成功....");
                    new MainUI();
                } else {
                    System.out.println("注册失败....");
                    new MainUI();
                    // 之后调用了mainMenu方法
                }
            } else {
                System.out.println("两次密码不同，请重新注册..");
                registUI.clear();
            }
        } else {
            System.out.println(password);
            new RegistUI();
        }
    }

    public static void loginOperation(Integer sno, String pwd) {
        Student result = ss.login(sno, pwd);//调用service层登录方法
        if (result != null) {
            System.out.println("登录成功...");
            student = result;
            if (StudentRole.班长.toString().equals(result.getRole())) {
                studentMenu(result);
            } else if (StudentRole.组长.toString().equals(result.getRole())) {
                studentMenu1(result);
            } else if (StudentRole.学员.toString().equals(result.getRole())) {
                studentMenu2(result);
            }
        } else {
            System.out.println("用户或密码错误，请再次登录...");
            new LoginUI();
        }
    }




    /**
     * 增加学生信息
     */
    public static void addInfo() {
        Scanner scanner = new Scanner(System.in);
        Student stu = new Student();
        stu = AddId.getId(stu);
        System.out.println("----------学号：");
        //输入学号(判断是不是数字)、密码
        Integer sno = JudgeNo.judge();
        stu.setSno(sno);//学号存入student
        add(stu);
        stu.setRole(StudentRole.学员.toString());
        Student result = ss.addInfo(stu);
        if (result != null) {
            System.out.println("增加成功....");
            judgeRole(student);
        } else {
            System.out.println("增加失败...");
            judgeRole(student);
            // 之后调用了mainMenu方法
        }
    }

    /**
     * 班长增加学生信息
     */
    public static void addInfoB() {
        Student stu = new Student();
        Scanner scanner = new Scanner(System.in);
        stu = AddId.getId(stu);
        System.out.println("----------学号：");
        //输入学号(判断是不是数字)、密码
        Integer sno = JudgeNo.judge();
        stu.setSno(sno);//学号存入student
        add(stu);
        System.out.println("--------角色(班长、组长、学员)：");
        String role = scanner.next();
        stu.setRole(role);
        stu.setRole(role);
        Student result = ss.addInfo(stu);
        if (result != null) {
            System.out.println("增加成功...");
            judgeRole(student);
        } else {
            System.out.println("增加失败...");
            judgeRole(student);
            // 之后调用了mainMenu方法
        }
    }

    //    查找学生信息
    public static void fingInfo() {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入需要查找的学号：");
        Integer sno = JudgeNo.judge();//调用判断整数的类
//        Student flag = ss.findInfo(sno);
        Student flag = ss.findInfo(sno);
//        System.out.println(flag);
        if (flag != null) {
            System.out.println("查找成功");
            judgeRole(student);
        } else {
            System.out.println("查找失败");
            judgeRole(student);
        }

    }

    //    删除学生信息
    public static void deleteInfo() {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入需要删除的学号：");
        Integer sno = JudgeNo.judge();
        boolean flag = ss.deleteInfo(sno);
        if (flag) {//判断返回的值
            System.out.println("删除成功");
            judgeRole(student);
        } else {
            System.out.println("删除失败");
            judgeRole(student);
        }
    }

    //    更新学生信息
    public static void updateInfo() {
        Student stu = new Student();//存储数据
        System.out.println("请输入需要修改的学生学号：");
        Integer sno = JudgeNo.judge();
        stu.setSno(sno);//数据存储到学生类
        System.out.println("输入你要改的信息：");
        add(stu);
        System.out.println("-------角色(班长、组长、学员)：");
        String role = sc.next();
        stu.setRole(role);
        //调用service层方法
        boolean flag = ss.updateInfo(stu);
        if (flag) {
            System.out.println("修改成功");
            judgeRole(student);
        } else {
            System.out.println("修改失败");
            judgeRole(student);
        }

    }

//    学生点名
    public static void getSname() {
       String name = ss.getName();
       if (name != null && !name.equals("")) {
           System.out.println("随机点到的学生名：" + name);
           judgeRole(student);
       }

    }

    public static void judgeRole(Student student) {
        if (StudentRole.班长.toString().equals(student.getRole())) {
            studentMenu(student);
        } else if (StudentRole.组长.toString().equals(student.getRole())) {
            studentMenu1(student);
        } else if (StudentRole.学员.toString().equals(student.getRole())) {
            studentMenu2(student);
        }
    }

    public static void add(Student student) {
        System.out.println("----------密码：");
        String pwd = sc.next();
        student.setPwd(pwd);
        System.out.println("---------姓名：");
        String sname = sc.next();
        student.setSname(sname);
        System.out.println("---------班级：");
        String gender = sc.next();
        student.setGrade(gender);
        System.out.println("---------宿舍：");
        String dept = sc.next();
        student.setDept(dept);
        System.out.println("---------邮箱：");
        String e_mail = sc.next();
        String s = JudgeMail.getMail(e_mail);
        while (true) {
            if (!"0".equals(s)) {
                student.setE_mail(e_mail);
                break;
            } else {
                System.out.println("请重新输入邮箱：");
                e_mail = sc.next();
                s = JudgeMail.getMail(e_mail);
            }
        }
    }
}
