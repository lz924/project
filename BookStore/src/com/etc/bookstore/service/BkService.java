package com.etc.bookstore.service;

import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Users;

import java.util.List;

public interface BkService {
//    图书上架
    public Bk addBook(Bk bk);
//    图书售空
    public Bk deleteAllInfo();
//    删除目标书籍
    public Bk deleteInfo(String sno);
//    修改图书信息
    public Bk updateBook(String name, Bk book);
//    查看目标图书
    public Bk findInfo(Bk bk);
//    查看所有图书
    public List<Bk> findAllInfo();

}
