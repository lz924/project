package com.etc.bookstore.dao;

import com.etc.bookstore.entity.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface OrdeDao {
//    添加用户
    public int addUser(Users user_no) throws SQLException;
//    添加图书
    public int addBook(Bk book_no) throws SQLException;
//    添加订单
    public int addOrde(Orde orde) throws SQLException;
//    查询订单
    public List<Orde> getOrdeOther() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;
//    添加销售单
    public int addSale(Sale sale) throws SQLException;
//    添加销售员
    public int addSell(Seller sell_no) throws SQLException;
//   添加订单编号
    public int getOrde(Orde order_no) throws SQLException;
//   查看售货员
    public List<Seller> findSell() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;
//    单独添加销售员
    public int addSeller(Seller seller) throws SQLException, URISyntaxException, IOException, ClassNotFoundException;
//   查看售货单
    public List<Sale> getAllSale() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

//
}
