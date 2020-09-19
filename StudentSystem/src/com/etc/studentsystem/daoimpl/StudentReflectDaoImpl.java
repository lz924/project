package com.etc.studentsystem.daoimpl;

import com.etc.studentsystem.dao.StudentDao;
import com.etc.studentsystem.entity.Node;
import com.etc.studentsystem.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentReflectDaoImpl<N,S> implements StudentDao {



    static Student[] student;
    static Class sc = Student.class;
    static Constructor con;

    static {
        try {
            con = sc.getConstructor(new Class[]{Integer.class, String.class, String.class, String.class, String.class, String.class});
            student = new Student[10];
            student[0] = (Student) con.newInstance(new Object[]{1817700123, "123qq", "xjq", "2018级1班", "503", "班长"});
            student[1] = (Student) con.newInstance(new Object[]{1817700125, "456aa", "xlj", "2018级2班", "403", "组长"});
            student[2] = (Student) con.newInstance(new Object[]{1817700128, "789zz", "ztx", "2018级3班", "603", "学员"});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
//    List<Student> list = Arrays.asList(student);

    //    Student[] student;
//    {
//        try {
//            student = (String)sc.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//    static Student[] student;
////        初始化数据写在静态块
//    static {
//        student = new Student[10];
//        student[0] = new Student(1817700123, "123qq", "xjq", "2018级1班", "503","班长");
//        student[1] = new Student(1817700125, "456aa", "xlj", "2018级2班", "403","组长");
//        student[2] = new Student(1817700128, "789zz", "ztx", "2018级3班", "603","学员");
//    }

//    静态块可以写多个，但是不建议这么写

    /**
     * 过学号判断密码，并登录(对象数组)
     * @param sno
     * @param pwd
     * @return
     */
    public Student login(Integer sno, String pwd) {
//        定义布尔类型标识
        Student s = null;
//        遍历静态数组
        for (int i = 0; i < student.length; i++) {
            //判断有无此用户
            if (student[i] != null) {
                if (sno.equals(student[i].getSno()) && pwd.equals(student[i].getPwd())) {
                    s = student[i];
                    break;
                }
            }
        }
        return s;
    }

    /**
     * 实现注册功能
     * @param sno
     * @param stu
     * @return
     */
    public String regist(Integer sno, Student stu) {
//        定义布尔标识
        boolean flag = false;
//        遍历数组
        for (int i = 0; i < student.length; i++) {
            //判断是否有位置
            if (student[i] != null){
//            if (!Objects.isNull(stu)){
                if (sno.equals(student[i].getSno())) {
                    System.out.println("此用户存在...");
                    flag = false;
                    break;
                }
            }else {
//             不满足上述条件之后添加用户
                student[i] = stu;
                flag = true;
            }
//            if (student[i] != null) {
//                if (sno.equals(student[i].getSno())) {
//                    System.out.println("此班级已满或此用户存在...");
//                    flag = false;
//                    break;
//                }
//            } else {
////             不满足上述条件之后添加用户
//                student[i] = stu;
////                System.out.println(Arrays.toString(student));
//                flag = true;
//                break;
//            }
        }
//        判断标识符，并返回结果值
        if (flag) {
            return "注册成功...";
        } else {
            return "学生已经存在...";
        }
    }

    /**
     * 增加学生信息
     * @param stu
     * @return
     */
    public Student addInfo(Student stu) {
//        添加布尔标识
        Student s = null;
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {//判断有无此用户
                if (stu.getSno().equals(student[i].getSno())) {
                    System.out.println("此班级已满或此用户存在...");
                    break;//满足条件结束遍历
                }
            } else {
                student[i] = stu;//添加学生信息
                s = student[i];
//                System.out.println(Arrays.toString(student));
                break;
            }
        }
        //        判断标识符，并返回结果值
        return s;
    }

    /**
     *
     * 通过sno查找学生
     */
    public Student findInfo(Integer sno) {
        Student s = null;
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                if (sno .equals(student[i].getSno()) ) {
                    System.out.println(student[i].toString());
                    s = student[i];
                    break;
                }
            }else {
                System.out.println("用户不存在...");
                break;
            }
        }
        return s;
    }

    @Override
    public String getSname() {
        return null;
    }

    /**
     *
     * 通过sno删除学生
     */
    public boolean deleteInfo(Integer sno) {
        boolean flag = false;
        for (int i = 0; i < student.length; i++) {
//            System.out.println("333333" + student[i]);
            if (student[i] != null) {
                if (sno.equals(student[i].getSno())) {
//                System.out.println("222222" + student[i]);
                    student[i] = null;
//                for (int j = 0; j < student.length; j++) {
//                    System.out.println("1111" + student[j]);
//                }
                    flag = true;
                    break;
                }
            }else {
                System.out.println("用户不存在...");
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     *
     * 修改学生信息
     */
    public boolean updateInfo(Student stu) {
        boolean flag = false;
        for (int i = 0; i < student.length; i++) {
//            if (student[i].getSno() != stu.getSno()) {
//                S
//            }
            if (student[i] != null) {
                if (stu.getSno().equals(student[i].getSno())) {
                    System.out.println("修改前：" + student[i].toString());
                    student[i] = stu;
                    System.out.println("修改后：" + student[i].toString());
                    flag = true;
                    break;
                }
            }else{
                System.out.println("用户不存在...");
                flag = false;
                break;
            }
        }
        return flag;
    }

}
