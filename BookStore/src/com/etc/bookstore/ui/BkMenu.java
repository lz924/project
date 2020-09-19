package com.etc.bookstore.ui;

import com.etc.bookstore.service.*;
import com.etc.bookstore.entity.*;
import com.etc.bookstore.serviceimpl.*;
import com.etc.bookstore.util.JudgeNo;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BkMenu {
    public void mainMenu() throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        System.out.println("---------------欢迎进入图书管理系统-------------");
        System.out.println("-------------- 1、注册----------");
        System.out.println("-------------- 2、登录----------");
        System.out.println("-------------- 3、用户角色----------");
        System.out.println("-------------- 4、退出系统----------");
        System.out.println("请输入进行操作的序号...");
        int num = JudgeNo.judge();
        switch (num) {
            case 1:
                System.out.println("注册");
                this.regist();
                break;
            case 2:
                System.out.println("登录");
                this.login();
                break;
            case 3:
                System.out.println("查看用户角色");
                this.getUserRole();
                break;
            case 4:
                System.out.println("退出系统");
                System.exit(0);
                break;
            default:
                System.out.println("请输入数字（1-4）!!");
                mainMenu();
        }
        System.out.println();
        this.mainMenu();
    }

    public void bookMenu() throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        System.out.println("---------------欢迎进入图书管理系统-------------");
//        设计需要实现的功能模块
        System.out.println("---------- 1、添加图书信息----------");
        System.out.println("---------- 2、查看所有图书信息----------");
        System.out.println("---------- 3、查看目标图书信息----------");
        System.out.println("---------- 4、修改图书信息----------");
        System.out.println("---------- 5、删除所有图书信息----------");
        System.out.println("---------- 6、删除目标图书信息----------");
        System.out.println("---------- 7、添加订单信息----------");
        System.out.println("---------- 8、查询订单信息----------");
        System.out.println("---------- 9、添加销售单信息----------");
        System.out.println("---------- 10、查询销售单信息----------");
        System.out.println("---------- 11、添加售货员信息----------");
        System.out.println("---------- 0、退出学生系统----------");
        bookSelect();
    }

    private void bookSelect() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        System.out.println("请输入进行操作的序号...");
        int num = JudgeNo.judge();
        switch (num) {
            case 1:
                System.out.println("添加图书信息");
//                this.addBook();
                this.addBookOther();
                break;
            case 2:
                System.out.println("查看所有图书信息");
//                this.findAllInfo();
                this.getBookOther();
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
                System.out.println("添加订单");
                this.addOrderOther();
                break;
            case 8:
                System.out.println("查询订单");
                this.getOrdeOther();
                break;
            case 9:
                System.out.println("添加销售单");
                this.addSale();
                break;
            case 10:
                System.out.println("查询销售单");
                this.getAllSale();
                break;
            case 11:
                System.out.println("添加售货员信息");
                this.addSell();
                break;
            case 0:
                System.out.println("退出学生管理系统...");
                this.mainMenu();
                break;
            default:
                System.out.println("请输入数字（1-9）!!");
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

    //    删除所有书信息
    public void deleteAllInfo() {
        BookService bs = new BookServiceImpl();
        Book book = bs.deleteAllInfo();
        if (book == null) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }

    //    根据书名删除书的信息
    public void deleteInfo() {
        System.out.println("请输入你所要删除图书的名称：");
        Scanner input = new Scanner(System.in);
        BkService ss = new BkServiceImpl();
        Bk book = ss.deleteInfo(input.next());
        if (book == null) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //   修改图书信息
    public void updateBook() {
        Bk book = new Bk();
        Scanner input = new Scanner(System.in);
        BkService bs = new BkServiceImpl();
        System.out.println("请输入需要修改的书名");
        String n = input.next();
        book.setBook_name(n);
        System.out.println("请输入书名");
        String name = input.next();
        book.setBook_name(name);
        System.out.println("请输入作者：");
        String author = input.next();
        book.setAuthor(author);
        System.out.println("请输入价格：");
        double price = input.nextDouble();
        book.setPrice(price);
        System.out.println("请输入出版社：");
        String press = input.next();
        book.setPress(press);
        Bk b = bs.updateBook(name,book);
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
        Bk book = new Bk();
        System.out.println("请输入所要查询的图书名称");
        String name = input.next();
        book.setBook_name(name);
        BkService bs = new BkServiceImpl();
        Bk b = bs.findInfo(book);
        if (b != null) {
            System.out.println("查询成功");
            System.out.println(b.toString());
        } else {
            System.out.println("没有此书");
        }
    }



//    用户登录
    Users users = new Users();
    public void login() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        UserService bs = new UserServiceImpl();
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String pwd = input.next();
        users = bs.login(name,pwd);
        if (users != null){
            System.out.println("登录成功");
            this.bookMenu();
        } else {
            System.out.println("登录失败");
            this.mainMenu();
        }
    }

//    用户注册
    public void regist() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        UserService bs = new UserServiceImpl();
        System.out.println("请输入角色：");
        Role role = new Role(input.next());
        System.out.println("请输入姓名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String pwd = input.next();
        System.out.println("请输入邮箱：");
        String email = input.next();
        Users users = new Users(name, pwd, email,role);
        int u = bs.regist(users);
        if (u > 0){
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
        this.mainMenu();
    }

//    添加书类型
    public void addBookOther() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        OtherService bs = new OtherServiceImpl();
        System.out.println("请输入所属仓库名称：");
        Repertory repertory = new Repertory(input.next());
        System.out.println("请输入书的类型名称");
        Type type = new Type(input.next());
        System.out.println("请输入书名：");
        String name = input.next();
        System.out.println("请输入作者：");
        String author = input.next();
        System.out.println("请输入价格：");
        double price = input.nextDouble();
        System.out.println("请输入出版社：");
        String press = input.next();
        Bk b = new Bk(repertory,type,name,author,price,press);
        int u = bs.addBookOther(b);
        if (u > 0){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        this.bookMenu();
    }
    //    查看所有书
    public void findAllInfo() {
        BookService bs = new BookServiceImpl();
        List<Book> b = bs.findAllInfo();
        int size = b.size();
        int count = 0;
        if (b.size() > 0) {
            for (int i = 0; i < size; i++) {
                Book book = b.get(i);
                if (book != null) {
                    count++;
                    System.out.println("图书名称 ：" + book.getBname() );
                    System.out.println("图书价格 ：" + book.getPrice());
                } else {
                    System.out.println("此书店无书");
                }
            }
            System.out.println("共计" + count + "本书");
        } else {
            System.out.println("此书店无书");
        }
    }
//    添加订单及其他
    public void addOrderOther() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        OrdeService bs = new OrdeServiceImpl();
        this.findAllInfo();
        System.out.println("需要购买的图书名称");
        Bk bk = new Bk(input.next());
        System.out.println("请输入订单名称：");
        String name = input.next();
        System.out.println("请输入订单评论：");
        String comment = input.next();
        Orde orde = new Orde(users, bk, name, comment);
        int u = bs.addOrderOther(orde);
        if (u > 0){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        this.bookMenu();
    }
//    查询用户角色
    public void getUserRole(){
        UserService ss = new UserServiceImpl();
        List<Role> roles = ss.getUserRole();
        for (Role r : roles
        ) {
            System.out.println("角色名称：" + r.getRole_name() + "         " + "角色ID:" + r.getRole_no());
            for (Users u: r.getUsers()
            ) {
                System.out.println("用户姓名：" + u.getUser_name() + "             " + "用户Email：" + u.getUser_email());
            }
        }
    }
//    查询书的仓库、类型
    public void getBookOther(){
        OtherService ss = new OtherServiceImpl();
        List<Bk> bks = ss.getBookOther();
        for (Bk bk : bks
        ) {
            System.out.println("图书名称：" + bk.getBook_name() + "         " + "图书ID:" + bk.getBook_no());
            System.out.println("类型名称：" + bk.getType_no().getType_name() + "         " + "类型ID:" + bk.getType_no().getType_no());
            System.out.println("仓库名称：" + bk.getRepertory_no().getRepertory_name() + "         " + "仓库ID:" + bk.getRepertory_no().getRepertory_no());
        }
    }
//    查看订单
    public void getOrdeOther() {
        OrdeService ss = new OrdeServiceImpl();
        List<Orde> ordes = ss.getOrdeOther();
        for (Orde orde : ordes
        ) {
            System.out.println("订单名称：" + orde.getOrder_name() + "         " + "订单ID:" + orde.getOrder_no());
            System.out.println("用户名称：" + orde.getUser_no().getUser_name() + "         " + "用户ID:" + orde.getUser_no().getUser_no());
            System.out.println("图书名称：" + orde.getBook_no().getBook_name() + "         " + "图书ID:" + orde.getBook_no().getBook_no());
        }
    }
    //    查看售货员
    public void findSell() {
        OrdeService bs = new OrdeServiceImpl();
        List<Seller> sellers = bs.findSell();
        for (Seller s : sellers
             ) {
            System.out.println("售货员名称 ：" +s.getSell_name() );
        }
    }

    //    添加销售单
    public void addSale() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        OrdeService bs = new OrdeServiceImpl();
        List<Orde> ordes = bs.getOrdeOther();
        for (Orde orde : ordes
        ) {
            System.out.println("订单名称：" + orde.getOrder_name());

        }
        System.out.println("选择需要支付的订单名称");
        Orde o = new Orde(input.next());
        System.out.println("选择售货员姓名");
        this.findSell();
        Seller seller = new Seller(input.next());
        System.out.println("请输入销售单名称：");
        String name = input.next();
        Sale sale = new Sale(o, seller,name, new Date());
        int u = bs.addSale(sale);
        if (u > 0){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        this.bookMenu();
    }
    //    图书上架
    public void addSell() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        Seller seller = new Seller();
        Scanner input = new Scanner(System.in);
        OrdeService bs = new OrdeServiceImpl();
        System.out.println("请输入售货员姓名：");
        String name = input.next();
        seller.setSell_name(name);
        System.out.println("请输入电话号：");
        String phone = input.next();
        seller.setSell_phone(phone);
        System.out.println("请输入地址：");
        String address = input.next();
        seller.setSell_address(address);
        int b = bs.addSeller(seller);
        if (b > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
//    查看销售单信息
    public void getAllSale() {
        OrdeService ss = new OrdeServiceImpl();
        List<Sale> sales = ss.getAllSale();
        for (Sale s : sales
        ) {
            System.out.println("销售单名称：" + s.getSale_name() + "         " + "销售单ID:" + s.getSale_no());
            System.out.println("订单名称：" + s.getOrder_no().getOrder_name() + "         " + "订单ID:" + s.getOrder_no().getOrder_no());
            System.out.println("销售员名称：" + s.getSell_no().getSell_name() + "         " + "销售员电话:" + s.getSell_no().getSell_phone());
        }
    }
}


