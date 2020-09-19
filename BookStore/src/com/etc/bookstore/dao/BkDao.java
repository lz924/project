package com.etc.bookstore.dao;

import com.etc.bookstore.entity.Bk;

import java.util.List;

public interface BkDao {
    //    图书上架
    public Bk addBook(Bk bk);
//    图书售空
    public Bk deleteAllInfo();
//    删除目标图书
    public Bk deleteInfo(String sno);
//    修改图书信息
    public Bk updateInfo(String name, Bk bk);
//    查找图书
    public Bk findInfo(Bk bk);
//    查看所有图书
    public List<Bk> findAllInfo();
}
