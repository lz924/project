package com.etc.bookstore.ui;

import com.etc.bookstore.entity.Book;
import com.etc.bookstore.service.BookService;
import com.etc.bookstore.serviceimpl.BookServiceImpl;
import com.etc.bookstore.util.JudgeNo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void mainMenu() {
        System.out.println("---------------欢迎进入图书管理系统-------------");
        System.out.println("-------------- 1、登录----------");
        System.out.println("-------------- 2、退出系统----------");
        System.out.println("请输入进行操作的序号...");
        int num = JudgeNo.judge();
        switch (num) {
            case 1:
                System.out.println("登录");
                this.login();
                break;
            case 2:
                System.out.println("退出系统");
                System.exit(0);
                break;
            default:
                System.out.println("请输入数字（1-2）!!");
                mainMenu();
        }
        System.out.println();
        this.mainMenu();
    }

    public void login() {

    }

    public void bookMenu() {
        System.out.println("---------------欢迎进入图书管理系统-------------");
//        设计需要实现的功能模块
        System.out.println("---------- 1、添加图书信息----------");
        System.out.println("---------- 2、查看所有图书信息----------");
        System.out.println("---------- 3、查看目标图书信息----------");
        System.out.println("---------- 4、修改图书信息----------");
        System.out.println("---------- 5、删除所有图书信息----------");
        System.out.println("---------- 6、删除目标图书信息----------");
        System.out.println("---------- 7、退出学生系统----------");
        bookSelect();
    }

    private void bookSelect() {
        System.out.println("请输入进行操作的序号...");
        int num = JudgeNo.judge();
        switch (num) {
            case 1:
                System.out.println("添加图书信息");
                this.addBook();
                break;
            case 2:
                System.out.println("查看所有图书信息");
                this.findAllInfo();
                break;
            case 3:
                System.out.println("查看目标图书信息");
                this.findInfo();
                break;
            case 4:
                System.out.println("修改图书信息");
                this.updateBook();
                break;
            case 5:
                System.out.println("删除所有图书信息");
                this.deleteAllInfo();
                break;
            case 6:
                System.out.println("删除目标图书");
                this.deleteInfo();
                break;
            case 7:
                System.out.println("退出学生管理系统...");
                this.mainMenu();
                break;
            default:
                System.out.println("请输入数字（1-5）!!");
                bookSelect();
        }
        System.out.println();
        this.bookMenu();
    }

    //    图书上架
    public void addBook() {
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        BookService bs = new BookServiceImpl();
        System.out.println("请输入书号：");
        String bno = input.next();
        book.setBno(bno);
        System.out.println("请输入书名：");
        String bname = input.next();
        book.setBname(bname);
        System.out.println("请输入作者：");
        String author = input.next();
        book.setAuthor(author);
        System.out.println("请输入价格：");
        double price = input.nextDouble();
        book.setPrice(price);
        System.out.println("请输入出版社：");
        String press = input.next();
        book.setPress(press);
        Book b = bs.addBook(book);
        if (b == null) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //    删除所有学生信息
    public void deleteAllInfo() {
        BookService bs = new BookServiceImpl();
        Book book = bs.deleteAllInfo();
        if (book == null) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }

    //    根据学号删除学生信息
    public void deleteInfo() {
        System.out.println("请输入你所要删除学生的学号");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学号：");
        String sno = input.next();
        BookService ss = new BookServiceImpl();
        Book book = ss.deleteInfo(sno);
        if (book == null) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //   修改图书信息
    public void updateBook() {
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        BookService bs = new BookServiceImpl();
        System.out.println("请输入需要修改的书号");
        System.out.println("请输入书号：");
        String bno = input.next();
        book.setBno(bno);
        System.out.println("请输入书名：");
        String bname = input.next();
        book.setBname(bname);
        System.out.println("请输入作者：");
        String author = input.next();
        book.setAuthor(author);
        System.out.println("请输入价格：");
        double price = input.nextDouble();
        book.setPrice(price);
        System.out.println("请输入出版社：");
        String press = input.next();
        book.setPress(press);
        Book b = bs.updateBook(book);
        if (b != null) {
            System.out.println("修改成功");
            System.out.println(b.toString());
        } else {
            System.out.println("修改失败");
        }
    }

    //    查看图书
    public void findInfo() {
        Scanner input = new Scanner(System.in);
        Book book = new Book();
        System.out.println("请输入所要查询的图书书号");
        System.out.println("请输入书号：");
        String bno = input.next();
        book.setBno(bno);
        BookService bs = new BookServiceImpl();
        Book b = bs.findInfo(book);
        if (b != null) {
            System.out.println("查询成功");
            System.out.println(b.toString());
        } else {
            System.out.println("没有此书");
        }
    }

    //    查看所有书
    public void findAllInfo() {
        BookService bs = new BookServiceImpl();
        List<Book> b = bs.findAllInfo();
        int size = b.size();
        if (b.size() > 0) {
            for (int i = 0; i < size; i++) {
                Book book = b.get(i);
                if (book != null) {
                    System.out.println("第" + (i + 1) + "本书");
                    System.out.println(book.toString());
                } else {
                    System.out.println("此书店无书");
                }
            }
        } else {
            System.out.println("此书店无书");
        }
    }

}


