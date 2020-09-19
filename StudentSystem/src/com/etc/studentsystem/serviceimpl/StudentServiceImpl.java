package com.etc.studentsystem.serviceimpl;

import com.etc.studentsystem.dao.StudentDao;
import com.etc.studentsystem.daoimpl.StudentDaoImpl;
import com.etc.studentsystem.entity.Student;
import com.etc.studentsystem.service.StudentService;

public class StudentServiceImpl {
    // 类里面直接创建一个类的对象，这样不管是这个类的哪个方法都可以使用
    StudentDao dao = new StudentDaoImpl();

    /**
     * 登录
     *
     * @param sno
     * @param pwd
     * @return
     */
    public Student login(Integer sno, String pwd) {
        if (sno != 0 && !"".equals(pwd)) ;//学号和密码不能为空
            return dao.login(sno, pwd);
    }

    /*
   注册学生信息
    */
    public String regist(Integer sno,Student student){
        if (sno != null && student != null){
            return dao.regist(sno,student);
        }else{
            return "学号不能为空...";
        }
    }

//    查看学生信息

    public Student findInfo(Integer sno) {
        if (sno != 0 && sno != null) ;//学号不能为空
        return dao.findInfo(sno);
    }

//    删除学生
    public boolean deleteInfo(Integer sno) {
        if (sno != 0 && sno != null) {//学号不能为空
            return dao.deleteInfo(sno);
        } else {
            return false;
        }
    }

    //    修改学生
    public boolean updateInfo(Student stu) {
        if (stu.getSno() != null ) {//学号不能为空
            return dao.updateInfo(stu);
        } else {
            return false;
        }
    }

//    增加学生
    public Student addInfo(Student stu) {
        if (stu.getSno()!= null) ;//学号不能为空
        return dao.addInfo(stu);
    }
}
