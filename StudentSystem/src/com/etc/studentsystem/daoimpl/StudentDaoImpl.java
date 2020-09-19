package com.etc.studentsystem.daoimpl;


import com.etc.studentsystem.dao.StudentDao;
import com.etc.studentsystem.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;


public class StudentDaoImpl implements StudentDao {

    /**
     * 定义一个静态数组，数组模拟数据库
     */
    static Student[] student;

    //    初始化数据写在静态块
    static {
        student = new Student[10];
        student[0] = new Student(1234567896, 1817700123, "123qq", "xjq", "2018级1班", "503", "班长", "1542378@qq.com");
        student[1] = new Student(1234578945, 1817700125, "456aa", "xlj", "2018级2班", "403", "组长", "7815478@qq.com");
        student[2] = new Student(1596237844, 1817700128, "789zz", "ztx", "2018级3班", "603", "学员", "9515478@qq.com");
    }

//    静态块可以写多个，但是不建议这么写

    /**
     * 过学号判断密码，并登录(对象数组)
     *
     * @param sno
     * @param pwd
     * @return
     */
    @Override
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
     *
     * @param sno
     * @param stu
     * @return
     */
    @Override
    public String regist(Integer sno, Student stu) {
//        定义布尔标识
        boolean flag = false;
//        遍历数组
        for (int i = 0; i < student.length; i++) {
            //判断是否有位置
            if (student[i] != null) {
//            if (!Objects.isNull(stu)){
                if (sno.equals(student[i].getSno()) && stu.getId() == student[i].getId()) {
                    System.out.println("此用户存在...");
                    flag = false;
                    break;
                }
            } else {
//             不满足上述条件之后添加用户
                student[i] = stu;
                flag = true;
            }
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
     *
     * @param stu
     * @return
     */
    @Override
    public Student addInfo(Student stu) {
//        添加布尔标识
        Student s = null;
        for (int i = 0; i < student.length; i++) {
            //判断有无此用户
            if (student[i] != null) {
                if (stu.getSno().equals(student[i].getSno()) && stu.getId() == student[i].getId()) {
                    System.out.println("此班级已满或此用户存在...");
                    break;//满足条件结束遍历
                }
            } else {
                //添加学生信息
                student[i] = stu;
                s = student[i];
                break;
            }
        }
        //        判断标识符，并返回结果值
        return s;
    }

    /**
     * 通过sno查找学生
     */
    @Override
    public Student findInfo(Integer sno) {
        Student s = null;
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                if (sno.equals(student[i].getSno())) {
                    System.out.println(student[i].toString());
                    s = student[i];
                    break;
                }
            } else {
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
     * 通过sno删除学生
     */
    @Override
    public boolean deleteInfo(Integer sno) {
        boolean flag = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                if (sno.equals(student[i].getSno())) {
                    student[i] = null;
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

    /**
     * 修改学生信息
     */
    @Override
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
            } else {
                System.out.println("用户不存在...");
                flag = false;
                break;
            }
        }
        return flag;
    }

    /*
     * 访问数据库，校验用户登录信息
     */
//    public Student login(Integer sno, String pwd) throws Exception {
//        Student student = null;
//        String sql = "select * from student where sno=? and pwd=?";
//        this.openConnection();
//        PreparedStatement ps = this.conn.prepareStatement(sql);
//        ps.setString(1, sno);
//        ps.setString(2, pwd);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            student = new Student();
//            student.setSno(sno);
//            student.setPwd(pwd);
//            student.setSname(rs.getString("sname"));
//            student.setGrade(rs.getString("grade"));
//            student.setDept(rs.getString("phone"));
//            student.setRole(rs.getString("role"));
//            break;
//        }
//        rs.close();
//        ps.close();
//        return student;
//    }
}
