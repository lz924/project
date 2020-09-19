package com.etc.bookstore.serviceimpl;

import com.etc.bookstore.dao.BookDao;
import com.etc.bookstore.dao.OrdeDao;
import com.etc.bookstore.dao.OtherDao;
import com.etc.bookstore.daoimpl.BookDaoImpl;
import com.etc.bookstore.daoimpl.OrdeDaoImpl;
import com.etc.bookstore.daoimpl.OtherDaoImpl;
import com.etc.bookstore.entity.*;
import com.etc.bookstore.service.OrdeService;
import com.etc.bookstore.util.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OrdeServiceImpl implements OrdeService {
    /**
     * 添加订单
     * @param orde
     * @return
     */
    @Override
    public int addOrderOther(Orde orde) throws SQLException {
        OrdeDao dao = new OrdeDaoImpl();
        int no = 0;
        try {
//        打开事务
            ((OrdeDaoImpl)dao).openTransaction();
//            添加用户信息
            int user = orde.getUser_no().getUser_no();
            orde.getUser_no().setUser_no(user);
//            添加图书信息
            int book = dao.addBook(orde.getBook_no());
            orde.getBook_no().setBook_no(book);
//            添加书信息
            no = dao.addOrde(orde);
//        提交事务
            ((OrdeDaoImpl)dao).commitTransaction();
        }catch (Exception e) {
//        回滚事务
            ((OrdeDaoImpl)dao).rollbackTransaction();
//            添加日志
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }finally {
//        关闭资源
            ((OrdeDaoImpl)dao).closeDB();
        }
        return no;
    }

    @Override
    public List<Orde> getOrdeOther() {
        OrdeDao dao = new OrdeDaoImpl();
        List<Orde> ordes = null;
        try {
            ordes = dao.getOrdeOther();
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((OrdeDaoImpl) dao).closeDB();
        }
        return ordes;
    }

    @Override
    public int addSale(Sale sale) throws SQLException {
        OrdeDao dao = new OrdeDaoImpl();
        int no = 0;
        try {
//        打开事务
            ((OrdeDaoImpl)dao).openTransaction();
//            添加售货员信息
            int seller = dao.addSell(sale.getSell_no());
            sale.getSell_no().setSell_no(seller);
//            添加订单信息
            int order = dao.getOrde(sale.getOrder_no());
            sale.getOrder_no().setOrder_no(order);
//            添加书信息
            no = dao.addSale(sale);
//        提交事务
            ((OrdeDaoImpl)dao).commitTransaction();
        }catch (Exception e) {
//        回滚事务
            ((OrdeDaoImpl)dao).rollbackTransaction();
//            添加日志
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }finally {
//        关闭资源
            ((OrdeDaoImpl)dao).closeDB();
        }
        return no;
    }

    /**
     * 查询销售员
     * @return
     */
    @Override
    public List<Seller> findSell() {
        OrdeDao dao = new OrdeDaoImpl();
        List<Seller> sellers = null;
        try {
            sellers = dao.findSell();
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((OrdeDaoImpl) dao).closeDB();
        }
        return sellers;
    }
    /**
     * 增加销售员
     */
    @Override
    public int addSeller(Seller seller) throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
        OrdeDao dao = new OrdeDaoImpl();
        int s = 0;
        try {
            s = dao.addSeller(seller);
        }finally {
            ((OrdeDaoImpl)dao).closeDB();
        }
        return s;
    }

    /**
     * 查看销售单
     * @return
     */
    @Override
    public List<Sale> getAllSale() {
        OrdeDao dao = new OrdeDaoImpl();
        List<Sale> sales = null;
        try {
            sales = dao.getAllSale();
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((OrdeDaoImpl) dao).closeDB();
        }
        return sales;
    }
}
