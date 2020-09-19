package com.etc.bookstore.serviceimpl;

import com.etc.bookstore.dao.BkDao;
import com.etc.bookstore.dao.BookDao;
import com.etc.bookstore.daoimpl.BkDaoImpl;
import com.etc.bookstore.daoimpl.BookDaoImpl;
import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Book;
import com.etc.bookstore.service.BkService;
import com.etc.bookstore.service.BookService;

import java.util.List;

public class BkServiceImpl implements BkService {
    /**
     * 增加图书
     * @param bk
     * @return
     */
    @Override
    public Bk addBook(Bk bk) {
        Bk b = null;
        BkDao dao = new BkDaoImpl();
        try {
            b = dao.addBook(bk);
        } finally {
            ((BkDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 删除图书
     * @return
     */
    @Override
    public Bk deleteAllInfo() {
        Bk b = null;
        BkDao dao = new BkDaoImpl();
        try {
            b = dao.deleteAllInfo();
        } finally {
            ((BkDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 删除目标书籍
     * @return
     */
    @Override
    public Bk deleteInfo(String name) {
        Bk b = null;
        BkDao dao = new BkDaoImpl();
        try {
            b = dao.deleteInfo(name);
        } finally {
            ((BkDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 修改图书信息
     * @param bk
     * @return
     */
    @Override
    public Bk updateBook(String name ,Bk bk) {
        Bk b = null;
        BkDao dao = new BkDaoImpl();
        try {
            b = dao.updateInfo(name, bk);
        } finally {
            ((BkDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 查找目标图书
     * @param bk
     * @return
     */
    @Override
    public Bk findInfo(Bk bk) {
        BkDao dao = new BkDaoImpl();
        Bk b = null;
        try {
            b = dao.findInfo(bk);
        } finally {
//            关闭资源
            ((BkDaoImpl)dao).closeDB();
        }
        return b;
    }

    /**
     * 查看所有图书
     * @return
     */
    @Override
    public List<Bk> findAllInfo() {
        BkDao dao = new BkDaoImpl();
        List<Bk> books = null;
        try {
            books = dao.findAllInfo();
        } finally {
//            关闭资源
            ((BkDaoImpl)dao).closeDB();
        }
        return books;
    }
}
