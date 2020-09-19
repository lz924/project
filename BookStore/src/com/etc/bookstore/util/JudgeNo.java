package com.etc.bookstore.util;

import java.util.Scanner;

public class JudgeNo {
    public static int judge(){
        Scanner input = new Scanner(System.in);
        int no = 0;
        while (true){
            if (input.hasNextInt()){
                no = input.nextInt();
                break;
            }else {
                System.out.println("请输入数字！");
                input = new Scanner(System.in);
            }
        }
        return no;
    }
}
