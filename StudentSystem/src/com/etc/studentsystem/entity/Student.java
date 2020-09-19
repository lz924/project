package com.etc.studentsystem.entity;

import com.etc.studentsystem.util.JudgePwd;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 学生类
 * @author lz
 */
public class Student implements Serializable {
    private long Id;
    private Integer sno;
    private String pwd;
    private String sname;
    private String grade;
    private String dept;
    private String role;
    private String e_mail;

    public Student(long id, Integer sno, String pwd, String sname, String grade, String dept, String role, String e_mail) {
        this.Id = id;
        this.sno = sno;
        this.pwd = pwd;
        this.sname = sname;
        this.grade = grade;
        this.dept = dept;
        this.role = role;
        this.e_mail = e_mail;
    }

    public Student(Integer sno, String pwd, String sname, String grade, String dept, String role) {
        this.sno = sno;
        this.pwd = pwd;
        this.sname = sname;
        this.grade = grade;
        this.dept = dept;
        this.role = role;
    }

    /**
     *  构造方法
     */
    public Student() {
        super();
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "Student:" + "  "+
                "Id=" + Id + "  "+
                "sno=" + sno + "  "+
                "pwd='" + JudgePwd.pwdNoSee(pwd) + '\'' + "  "+
                "sname='" + sname + '\'' + "  "+
                "grade='" + grade + '\'' + "  "+
                "dept='" + dept + '\'' + "  " +
                "role="  + role +  '\'' + "  " +
                "e_mail="  + e_mail +  '\'' + "  "
                ;
    }
    //    构造方法（2）
//    public Student(Integer sno, String pwd, String sname, Integer age, String grade, String phone, String address) {
//        this.sno = sno;
//        this.pwd = pwd;
//        this.sname = sname;
//        this.age = age;
//        this.grade = grade;
//        this.phone = phone;
//        this.address = address;
//    }

//    //取值
//    public Integer getSno() {
//        return sno;
//    }
//    //存值
//    public void setSno(Integer sno) {
//        this.sno = sno;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    public String getSname() {
//        return sname;
//    }
//
//    public void setSname(String sname) {
//        this.sname = sname;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "sno=" + sno +
//                ", pwd='" + pwd + '\'' +
//                ", sname='" + sname + '\'' +
//                ", age=" + age +
//                ", grade='" + grade + '\'' +
//                ", phone=" + phone +
//                ", address='" + address + '\'' +
//                '}';
//    }
}
