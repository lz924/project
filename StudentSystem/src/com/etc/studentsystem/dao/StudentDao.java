package com.etc.studentsystem.dao;

import com.etc.studentsystem.entity.Student;

import javax.xml.soap.Node;
import java.lang.reflect.InvocationTargetException;

public interface StudentDao {
    /**
     * 用户登录约定
     */
    public Student login(Integer ano,String pwd);
//    public Student login(N sno, S pwd);
    /**
     * 用户注册约定
     */
    public String regist(Integer sno, Student student);
//    public String regist(N sno, S pwd);
    /**
     * 增加学生信息的约定
     */
    public Student addInfo(Student stu);
//    public String addInfo(N sno,S value);
    /**
     * 删除学生信息的约定
     */
    public boolean deleteInfo(Integer sno);
//    public String deleteInfo(N sno);
    /**
     * 修改学生信息的约定
     */
    public boolean updateInfo(Student stu);
//    public S updateInfo(N sno,S stu);
    /**
     * 查看学生信息的约定
     */
    public Student findInfo(Integer sno);

//    public String findInfo(N sno);


    public String getSname();
}
