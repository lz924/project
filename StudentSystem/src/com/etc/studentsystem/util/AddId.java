package com.etc.studentsystem.util;

import com.etc.studentsystem.entity.Student;

import java.math.BigInteger;
import java.util.Random;

/**
 * 随机增加学号
 * @author lz
 */
public class AddId {
    public static Student getId(Student student){
//        随机范围
        Random random = new Random();
        Long num = random.nextLong() / 1000;
        num = Math.abs(num);
        student.setId(num);
        return student;
    }
}
