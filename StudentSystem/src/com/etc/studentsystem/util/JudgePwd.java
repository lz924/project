package com.etc.studentsystem.util;

public class JudgePwd {
    public static String isPwd(String pwd) {
        int digit = 0;
        int upper = 0;
        int lower = 0;

        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (Character.isDigit(c)) {
                digit++;
            } else if (Character.isUpperCase(c)) {
                upper++;
            } else if (Character.isLowerCase(c)) {
                lower++;
            }
        }
        if (digit > 0 && upper > 0 && lower > 0) {
            return pwd;
        } else {
            return "密码需要包含数字，大写字母和小写字母...";
        }
    }

    public static void gradePwd(String pwd) {
        int len = pwd.length();
        if (len > 0 && len <= 5){
            System.out.println("密码当前等级为低级...");
        }else if(len > 5 && len <= 8){
            System.out.println("密码当前等级为中级...");
        }else if (len > 8 && len <= 15){
            System.out.println("密码当前等级为高级...");
        }else {
            System.out.println("密码很难记哦!!!!");
        }
    }

    public static String pwdNoSee(String pwd){
        String s = "";
        for (int i = 0; i < pwd.length(); i++) {
            s += "*";
        }

        return s;
    }
}
