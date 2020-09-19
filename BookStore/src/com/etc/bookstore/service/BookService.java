package com.etc.bookstore.service;

import com.etc.bookstore.entity.Book;

import java.util.List;

public interface BookService {
//    图书上架
    public Book addBook(Book book);
//    图书售空
    public Book deleteAllInfo();
//    删除目标书籍
    public Book deleteInfo(String sno);
//    修改图书信息
    public Book updateBook(Book book);
//    查看目标图书
    public Book findInfo(Book book);
//    查看所有图书
    public List<Book> findAllInfo();
}
