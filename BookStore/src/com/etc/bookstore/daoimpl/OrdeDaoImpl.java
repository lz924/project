package com.etc.bookstore.daoimpl;

import com.etc.bookstore.dao.OrdeDao;
import com.etc.bookstore.entity.*;
import com.etc.bookstore.util.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class OrdeDaoImpl extends BaseDaoImpl implements OrdeDao {
    /**
     * 添加用户
     * @return
     */
    @Override
    public int addUser(Users u) throws SQLException {
        String sql = "select user_no from user where user_pwd = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,u.getUser_pwd());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 添加图书
     * @return
     */
    @Override
    public int addBook(Bk bk) throws SQLException {
        String sql = "select book_no from book where book_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,bk.getBook_name());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 添加订单
     * @param orde
     * @return
     */
    @Override
    public int addOrde(Orde orde) throws SQLException {
        String sql = "insert into orde(user_no, book_no, order_name, order_comment) values (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,orde.getUser_no().getUser_no());
        preparedStatement.setInt(2,orde.getBook_no().getBook_no());
        preparedStatement.setString(3,orde.getOrder_name());
        preparedStatement.setString(4,orde.getOrder_comment());
        return preparedStatement.executeUpdate();
    }

    /**
     * 查询订单
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public List<Orde> getOrdeOther() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "select * from orde as o inner join user as u on o.user_no = u.user_no inner join book as b on o.book_no = b.book_no";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        List<Orde> ordes = new ArrayList<>();
        while(resultSet.next()){
            Users users = new Users();
            Bk bk = new Bk();
            users.setUser_no(resultSet.getInt(2));
            users.setUser_name(resultSet.getString(8));
            bk.setBook_no(resultSet.getInt(3));
            bk.setBook_name(resultSet.getString(14));
//            Users user_no, Bk book_no, String order_name, String order_comment
            Orde orde = new Orde(users,bk,resultSet.getString(4), resultSet.getString(5));
            ordes.add(orde);
        }
        return ordes;
    }

    /**
     * 添加销售单
     * @param sale
     * @return
     * @throws SQLException
     */
    @Override
    public int addSale(Sale sale) throws SQLException {
        String sql = "insert into sale(order_no, sell_no, sale_name, sale_date) values (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,sale.getOrder_no().getOrder_no());
        preparedStatement.setInt(2,sale.getSell_no().getSell_no());
        preparedStatement.setString(3,sale.getSale_name());
        preparedStatement.setDate(4, new Date(sale.getSale_date().getTime()));
        return preparedStatement.executeUpdate();
    }

    /**
     * 添加销售员
     * @return
     * @throws SQLException
     */
    @Override
    public int addSell(Seller seller) throws SQLException {
        String sql = "select sell_no from seller where sell_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,seller.getSell_name());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 得到订单id
     * @param order_no
     * @return
     * @throws SQLException
     */
    @Override
    public int getOrde(Orde order_no) throws SQLException {
        String sql = "select order_no from orde where order_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,order_no.getOrder_name());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 查看销售员
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public List<Seller> findSell() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "select * from seller";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        List<Seller> sellers = new ArrayList<>();
        while(resultSet.next()){
           Seller seller = new Seller();
           seller.setSell_no(resultSet.getInt(1));
           seller.setSell_name(resultSet.getString(2));
           seller.setSell_phone(resultSet.getString(3));
           seller.setSell_address(resultSet.getString(4));
           sellers.add(seller);
        }
        return sellers;
    }

    /**
     * 增加售货员
     * @param seller
     * @return
     */
    @Override
    public int addSeller(Seller seller) throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        openDB();
        String sql = "insert into seller(sell_name,sell_phone,sell_address) values(?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, seller.getSell_name());
        preparedStatement.setString(2, seller.getSell_phone());
        preparedStatement.setString(3, seller.getSell_address());
        int r = preparedStatement.executeUpdate();
        return r;
    }

    /**
     * 查看所有订单及相关信息
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public List<Sale> getAllSale() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "select * from sale as o inner join seller as u on o.sell_no = u.sell_no inner join orde as b on o.order_no = b.order_no";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        List<Sale> sales = new ArrayList<>();
        while(resultSet.next()){
            Seller seller = new Seller();
            Orde orde = new Orde();
            seller.setSell_no(resultSet.getInt(3));
            seller.setSell_name(resultSet.getString(7));
            seller.setSell_phone(resultSet.getString(8));
            orde.setOrder_no(resultSet.getInt(2));
            orde.setOrder_name(resultSet.getString(13));
//            Orde order_no, Seller sell_no, String sale_name, Date sale_date
            Sale sale = new Sale(orde,seller,resultSet.getString(4),resultSet.getDate(5));
            sale.setSale_no(resultSet.getInt(1));
            sales.add(sale);
        }
        return sales;
    }
}
