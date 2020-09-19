package com.etc.studentsystem.daoimpl;

import com.etc.studentsystem.dao.StudentDao;
import com.etc.studentsystem.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListDaoImple implements StudentDao {

    Student student ;
    static List<Student> list;
    static {
        //        创建一个文件对象，用来存储Student对象
        File file = new File("F:\\中软\\2020年7月21日\\学习内容\\test1\\Student.md");
        list = new ArrayList();
        list.add(new Student(1817700123, "123qq", "xjq", "2018级1班", "503","班长"));
        list.add(new Student(1817700125, "456aa", "xlj", "2018级2班", "403","组长"));
        list.add(new Student(1817700128, "789zz", "ztx", "2018级3班", "603","学员"));

        //        创建FileOutputStream对象
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //        创建对象输出流
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            //        关闭资源
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        //        反序列化
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ObjectInputStream objectInputStream = null;
//        try {
//            objectInputStream = new ObjectInputStream(fileInputStream);
//            list = (List<Student>) objectInputStream.readObject();
//            for (Student s : list
//                 ) {
//                System.out.println(s);
//            }
//            System.out.println();
//            System.out.println();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

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
        for (int i = 0; i < list.size(); i++) {
            //判断有无此用户
            if (list.get(i) != null) {
                if (sno.equals(list.get(i).getSno()) && pwd.equals(list.get(i).getPwd())) {
                    s = list.get(i);
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
        boolean flag = true;
//        遍历数组
        for (int i = 0; i < list.size(); i++) {
            //判断是否有位置
            if (list.get(i) != null) {
//            if (!Objects.isNull(stu)){
                if (sno.equals(list.get(i).getSno())) {
                    System.out.println("此用户存在...");
                    flag = false;
                    break;
                }
            }
        }
//        判断标识符，并返回结果值
        if (flag) {
//          不满足上述条件之后添加用户
            list.add(stu);
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
        boolean flag = true;
        Student s = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {//判断有无此用户
                if (stu.getSno().equals(list.get(i).getSno())) {
                    System.out.println("此班级已满或此用户存在...");
                    flag = false;
                    break;//满足条件结束遍历
                }
            }
        }
//      判断标识符，并返回结果值
        if (flag){
            //添加学生信息
            list.add(stu);
            s = stu;
            return s;
        }
        return null;
    }

    /**
     *
     * 通过sno查找学生
     */
    public Student findInfo(Integer sno) {
        Student s = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (sno .equals(list.get(i).getSno()) ) {
                    System.out.println(list.get(i));
                    s = list.get(i);
                    break;
                }
            }else {
                System.out.println("用户不存在...");
                break;
            }
        }
        return s;
    }



    /**
     *
     * 通过sno删除学生
     */
    public boolean deleteInfo(Integer sno) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (sno.equals(list.get(i).getSno())) {
                    list.remove(list.get(i));
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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (stu.getSno().equals(list.get(i).getSno())) {
                    System.out.println("修改前：" + list.get(i));
                    Student s = list.get(i);
                    s = stu;
                    System.out.println("修改后：" + s.toString());
                    flag = true;
                    break;
                }
            } else {
                System.out.println("用户不存在...");
                flag = false;
                break;
            }
        }
        return flag;

    }

    public String getSname() {
        Random random = new Random();
        String name = null;
        int num = random.nextInt(list.size());
        name = list.get(num).getSname();
        return name;
    }
}