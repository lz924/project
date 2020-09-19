package com.etc.bookstore.dao;

import com.etc.bookstore.entity.Book;

import java.util.List;

public interface BookDao {
    //    图书上架
    public Book addBook(Book book);
//    图书售空
    public Book deleteAllInfo();
//    删除目标图书
    public Book deleteInfo(String sno);
//    修改图书信息
    public Book updateInfo(Book book);
//    查找图书
    public Book findInfo(Book book);
//    查看所有图书
    public List<Book> findAllInfo();
}
