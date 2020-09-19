package com.etc.bookstore.dao;

import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Repertory;
import com.etc.bookstore.entity.Type;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface OtherDao {
//    添加类型
    int addType(Type type) throws SQLException;
//    添加仓库
    int addRepertory(Repertory repertory) throws SQLException;
//    添加书
    int addBk(Bk bk) throws SQLException;
    //    查询书及相关信息
    public List<Bk> getBookOther() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

}
