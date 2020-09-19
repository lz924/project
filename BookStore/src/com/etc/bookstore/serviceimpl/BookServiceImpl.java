package com.etc.bookstore.serviceimpl;

import com.etc.bookstore.dao.BookDao;
import com.etc.bookstore.daoimpl.BaseDaoImpl;
import com.etc.bookstore.daoimpl.BookDaoImpl;
import com.etc.bookstore.entity.Book;
import com.etc.bookstore.service.BookService;

import java.util.List;

public class BookServiceImpl extends BaseDaoImpl implements BookService {
    /**
     * 增加图书
     * @param book
     * @return
     */
    @Override
    public Book addBook(Book book) {
        Book b = null;
        BookDao dao = new BookDaoImpl();
        try {
            b = dao.addBook(book);
        } finally {
            ((BookDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 删除图书
     * @return
     */
    @Override
    public Book deleteAllInfo() {
        Book b = null;
        BookDao dao = new BookDaoImpl();
        try {
            b = dao.deleteAllInfo();
        } finally {
            ((BookDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 删除目标书籍
     * @param sno
     * @return
     */
    @Override
    public Book deleteInfo(String sno) {
        Book b = null;
        BookDao dao = new BookDaoImpl();
        try {
            b = dao.deleteInfo(sno);
        } finally {
            ((BookDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    @Override
    public Book updateBook(Book book) {
        Book b = null;
        BookDao dao = new BookDaoImpl();
        try {
            b = dao.updateInfo(book);
        } finally {
            ((BookDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 查找目标图书
     * @param book
     * @return
     */
    @Override
    public Book findInfo(Book book) {
        BookDao dao = new BookDaoImpl();
        Book b = null;
        try {
            b = dao.findInfo(book);
        } finally {
//            关闭资源
            ((BookDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 查看所有图书
     * @return
     */
    @Override
    public List<Book> findAllInfo() {
        BookDao dao = new BookDaoImpl();
        List<Book> books = null;
        try {
            books = dao.findAllInfo();
        } finally {
//            关闭资源
            ((BookDaoImpl)dao).closeDB();
        }
        return books;
    }
}
