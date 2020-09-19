package com.etc.studentsystem.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener {
    private JButton reBt;
    private JButton sureBt;
    private JButton quitBt;
    //创建一个容器
    private Container ct;
    //创建背景面板。
    private BackgroundPanel bgp;

    public MainUI(){
        //创建出控件对象（因为上面只是声明出来，并没有给出实际的空间)
        //注册按钮
        reBt = new JButton("注册");
        reBt.setSize(60, 25);
        reBt.setLocation(60, 100);

        //确认按钮
        sureBt = new JButton("登录");
        sureBt.setSize(60, 25);
        sureBt.setLocation(140, 100);

        //退出按钮
        quitBt = new JButton("退出");
        quitBt.setSize(60, 25);
        quitBt.setLocation(220, 100);

        ct=this.getContentPane();
        this.setLayout(null);
        bgp = new BackgroundPanel((new ImageIcon("E:\\Typora-img\\work-img\\timg.jfif")).getImage());
        bgp.setBounds(1,1,350,200);

        ct.add(reBt);
        ct.add(sureBt);
        ct.add(quitBt);
        ct.add(bgp);

        reBt.addActionListener(this);
        sureBt.addActionListener(this);
        quitBt.addActionListener(this);

        this.setSize(350, 200);
        this.setTitle("学生管理系统");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭JFrame
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        //锁定窗体
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "注册"){
            new RegistUI();
        } else if (e.getActionCommand() == "登录") {
            new LoginUI();
        } else if (e.getActionCommand() == "退出") {
            System.exit(0);
        }
    }//MainFrame类

}
class BackgroundPanel extends JPanel
{
    Image im;
    public BackgroundPanel(Image im)
    {
        this.im=im;
        this.setOpaque(true);
    }
    //Draw the back ground.
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

    }
}