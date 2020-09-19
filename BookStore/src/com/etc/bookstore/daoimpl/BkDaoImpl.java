package com.etc.bookstore.daoimpl;

import com.etc.bookstore.dao.BkDao;
import com.etc.bookstore.dao.BookDao;
import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Book;
import com.etc.bookstore.util.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BkDaoImpl extends BaseDaoImpl implements BkDao {
    public static void main(String[] args) {

    }


    /**
     * 增加图书
     *
     * @param bk
     * @return
     */
    @Override
    public Bk addBook(Bk bk) {
        Bk b = null;
        try {
            openDB();
            String sql = "insert into book values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bk.getBook_no());
            preparedStatement.setString(2, bk.getBook_name());
            preparedStatement.setString(3, bk.getAuthor());
            preparedStatement.setDouble(4, bk.getPrice());
            preparedStatement.setString(5, bk.getPress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//            日志
            Log.mylog.debug(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }
        return b;
    }

    /**
     * 删除所有图书
     *
     * @return
     */
    @Override
    public Bk deleteAllInfo() {
        Bk bk = null;
        try {
            openDB();
            String sql = "delete from book";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//            日志
            Log.mylog.debug(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }
        return bk;
    }

    /**
     * 删除目标图书
     * @return
     */
    @Override
    public Bk deleteInfo(String name) {
        Bk bk = null;
        try {
            openDB();
            String sql = "delete from book where book_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//            日志
            Log.mylog.debug(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }
        return bk;
    }

    /**
     * 修改图书信息
     * @param bk
     * @return
     */
    @Override
    public Bk updateInfo(String name, Bk bk) {
        try {
            openDB();
            String sql = "update book set book_name = ?, author = ?, price = ?, press = ? where book_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, bk.getAuthor());
            preparedStatement.setDouble(3, bk.getPrice());
            preparedStatement.setString(4, bk.getPress());
            preparedStatement.setString(5, bk.getBook_name());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
//            日志
            Log.mylog.debug(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }
        return bk;
    }

    /**
     * 查找图书
     * @param bk
     * @return
     */
    @Override
    public Bk findInfo(Bk bk) {
        Bk b = null;
        try {
            openDB();
            String sql = "select * from book where book_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bk.getBook_name());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                b = new Bk();
                b.setBook_no(resultSet.getInt("book_no"));
                b.setBook_name(resultSet.getString("book_name"));
                b.setAuthor(resultSet.getString("author"));
                b.setPrice(resultSet.getDouble("price"));
                b.setPress(resultSet.getString("press"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
//            日志
            Log.mylog.debug(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }
        return b;
    }

    /**
     * 查看所有图书
     * @return
     */
    @Override
    public List<Bk> findAllInfo() {
        List<Bk> bks = new ArrayList<>();
        try {
            openDB();
            String sql = "select * from book";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bk b = new Bk();
                b.setBook_no(resultSet.getInt("book_no"));
                b.setBook_name(resultSet.getString("book_name"));
                b.setAuthor(resultSet.getString("author"));
                b.setPrice(resultSet.getDouble("price"));
                b.setPress(resultSet.getString("press"));
                bks.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            日志
            Log.mylog.debug(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }
        return bks;
    }
}
