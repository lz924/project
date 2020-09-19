package com.etc.bookstore.daoimpl;

import com.etc.bookstore.dao.OtherDao;
import com.etc.bookstore.entity.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtherDaoImpl extends BaseDaoImpl implements OtherDao {
    /**
     * 添加类型
     * @return
     */
    @Override
    public int addType(Type type) throws SQLException {
        String sql = "insert into type(type_name) value(?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,type.getType_name());
//        执行SQL语句
        preparedStatement.executeUpdate();
        sql = "select type_no from type where type_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,type.getType_name());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 添加仓库
     * @return
     */
    @Override
    public int addRepertory(Repertory repertory) throws SQLException {
        String sql = "insert into repertory(repertory_name) value(?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,repertory.getRepertory_name());
//        执行SQL语句
        preparedStatement.executeUpdate();
        sql = "select repertory_no from repertory where repertory_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,repertory.getRepertory_name());
        resultSet = preparedStatement.executeQuery();
        int no = 0;
        while(resultSet.next()){
            no = resultSet.getInt(1);
        }
        return no;
    }

    /**
     * 添加书
     * @param bk
     * @return
     */
    @Override
    public int addBk(Bk bk) throws SQLException {
        String sql = "insert into book(repertory_no,type_no,book_name,author,price,press) value(?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,bk.getRepertory_no().getRepertory_no());
        preparedStatement.setInt(2,bk.getType_no().getType_no());
        preparedStatement.setString(3,bk.getBook_name());
        preparedStatement.setString(4,bk.getAuthor());
        preparedStatement.setDouble(5,bk.getPrice());
        preparedStatement.setString(6,bk.getPress());
        return preparedStatement.executeUpdate();
    }

    /**
     * 查询书及相关信息
     * @return
     */
    @Override
    public List<Bk> getBookOther() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "select * from book as b inner join type as t on b.type_no = t.type_no inner join repertory as r on b.repertory_no = r.repertory_no";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        List<Bk> bks = new ArrayList<>();
        while(resultSet.next()){
            Type type = new Type();
            Repertory repertory = new Repertory();
            repertory.setRepertory_no(resultSet.getInt(2));
            repertory.setRepertory_name(resultSet.getString(11));
            type.setType_no(resultSet.getInt(3));
            type.setType_name(resultSet.getString(9));
//            Repertory repertory_no, Type type_no, String book_name, String author, double price, String press
            Bk bk = new Bk(repertory,type,resultSet.getString(4), resultSet.getString(5), resultSet.getDouble(6), resultSet.getString(7));
            bks.add(bk);
        }
        return bks;
    }

}
