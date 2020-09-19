package com.etc.studentsystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lz
 */
public class JudgeMail {
    public static String getMail(String e_mail) {
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//        创建一个pattern对象
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(e_mail);
        if (matcher.matches()) {
            return regex;
        } else {
            System.out.println(e_mail + "    格式输入错误。。");
            return "0";
        }
    }
}
