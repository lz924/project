package com.etc.bookstore.service;

import com.etc.bookstore.entity.Bk;

import java.sql.SQLException;
import java.util.List;

public interface OtherService {
//    添加书
    public int addBookOther(Bk bk) throws SQLException;
//    查看书类型、仓库
    public List<Bk> getBookOther();
}
