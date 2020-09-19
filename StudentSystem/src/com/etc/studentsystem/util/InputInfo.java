package com.etc.studentsystem.util;

import com.etc.studentsystem.entity.Student;

import java.util.Scanner;

public class InputInfo {

    public static void InputIn() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------姓名：");
        String sname = scanner.next();
        student.setSname(sname);
        System.out.println("--------班级：");
        String gender = scanner.next();
        student.setGrade(gender);
        System.out.println("--------宿舍：");
        String dept = scanner.next();
        student.setDept(dept);

    }
}
