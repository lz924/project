package com.etc.studentsystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistUI extends JFrame implements ActionListener {
    //定义组件
    private JLabel jlb1;//标签
    private JLabel jlb2;
    private JLabel jlb3;
    private JLabel jlb4;
    private JTextField jtf;//文本
    private JPasswordField jpf;//密码
    private JPasswordField jpf1;
    private JButton reBt;
    private JButton chongBt;
    //创建一个容器
    private Container ct;
    //创建背景面板。
    private BackgroundPanel1 bgp;

    public RegistUI() {

        //创建标签
        jlb3 = new JLabel("学生管理系统");
        jlb3.setForeground(Color.WHITE);
        jlb3.setBounds(150,30,300,60);

        jlb1 = new JLabel("学    号");
        jlb1.setForeground(Color.WHITE);
        jlb1.setBounds(90,105,280,30);

        jlb2 = new JLabel("密    码");
        jlb2.setForeground(Color.WHITE);
        jlb2.setBounds(90,155,280,30);

        jlb4 = new JLabel("确认密码");
        jlb4.setForeground(Color.WHITE);
        jlb4.setBounds(90,205,280,30);

        //注册按钮
        reBt = new JButton("注册");
        reBt.setSize(60, 25);
        reBt.setLocation(90, 300);

        //重置按钮
        chongBt = new JButton("重置");
        chongBt.setSize(60, 25);
        chongBt.setLocation(190, 300);

        //设置监听
        reBt.addActionListener(this);
        chongBt.addActionListener(this);

        //创建文本框
        jtf = new JTextField("");
        jtf.setBackground(Color.WHITE);
        jtf.setBounds(160,110,120,18);

        //创建密码框
        jpf = new JPasswordField("");
        jpf.setBackground(Color.WHITE);
        jpf.setText("请输入密码：");
        jpf.setBounds(160,160,120,18);

        jpf1 = new JPasswordField("",15);
        jpf1.setBackground(Color.WHITE);
        jpf1.setText("请确认密码：");
        jpf1.setBounds(160,210,120,18);


        ct = this.getContentPane();
        bgp = new BackgroundPanel1((new ImageIcon("E:\\Typora-img\\work-img\\timg.jfif")).getImage());
        bgp.setBounds(0, 0, 350, 430);

        ct.add(jlb3);
        ct.add(jlb1);
        ct.add(jtf);
        ct.add(jlb2);
        ct.add(jpf);
        ct.add(jlb4);
        ct.add(jpf1);
        ct.add(reBt);
        ct.add(chongBt);
        ct.add(bgp);


        this.setLayout(null);
        this.setTitle("注册");//窗体标签
        this.setSize(350, 430);//窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭JFrame
        this.setVisible(true);//显示窗体

        //锁定窗体
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "注册"){
            String s = jtf.getText();
            Integer sno = Integer.parseInt(s);
            char[] password = jpf.getPassword();
            String pwd = String.valueOf(password);
            char[] password1 = jpf1.getPassword();
            String pwd1 = String.valueOf(password1);
            Menu.registOperstion(sno,pwd,pwd1);
        } else if (e.getActionCommand() == "重置") {
            clear();
        }
    }
    public void clear() {
        jtf.setText("");
        jpf.setText("");
    }
}

