package com.etc.bookstore.service;

import com.etc.bookstore.entity.Orde;
import com.etc.bookstore.entity.Sale;
import com.etc.bookstore.entity.Seller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface OrdeService {
//    添加订单及相关信息
    public int addOrderOther(Orde orde) throws SQLException;
//    查看订单信息
    public List<Orde> getOrdeOther();
//    添加销售单
    public int addSale(Sale sale) throws SQLException;
//    查询售货员
    public List<Seller> findSell();
//    添加售货员
    public int addSeller(Seller seller) throws ClassNotFoundException, SQLException, IOException, URISyntaxException;
//    查询售货的订单
    public List<Sale> getAllSale();
}
