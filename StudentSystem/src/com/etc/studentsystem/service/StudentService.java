package com.etc.studentsystem.service;

import com.etc.studentsystem.entity.Student;

public interface StudentService {
    /**
     * 用户登录约定
     */
    public Student login(Integer ano,String pwd);
//    public Student login(Integer sno, String pwd);
    /**
     * 用户注册约定
     */
    public String regist(Integer sno, Student student);
//    public String regist(Integer sno,Student student);
    /**
     * 增加学生信息的约定
     */
    public Student addInfo(Student stu);
//    public String addInfo(Integer sno ,Student stu);
    /**
     * 删除学生信息的约定
     */
    public boolean deleteInfo(Integer sno);
//    public String deleteInfo(Integer sno);
    /**
     * 修改学生信息的约定
     */
//    public Object updateInfo(Student stu);
    public boolean updateInfo(Student stu);
    /**
     * 查看学生信息的约定
     */
//    public Student findInfo(Integer sno);
    public Student findInfo(Integer sno);

    /**
     * 学生点名
     * @return
     */
    public String getName();
}
