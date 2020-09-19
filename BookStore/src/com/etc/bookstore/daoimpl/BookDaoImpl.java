package com.etc.bookstore.daoimpl;

import com.etc.bookstore.dao.BookDao;
import com.etc.bookstore.entity.Book;
import com.etc.bookstore.util.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDaoImpl implements BookDao {

    /**
     * 增加图书
     *
     * @param book
     * @return
     */
    @Override
    public Book addBook(Book book) {
        Book b = null;
        try {
            openDB();
            String sql = "insert into book values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBno());
            preparedStatement.setString(2, book.getBname());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getPress());
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
    public Book deleteAllInfo() {
        Book book = null;
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
        return book;
    }

    /**
     * 删除目标图书
     *
     * @param sno
     * @return
     */
    @Override
    public Book deleteInfo(String sno) {
        Book book = null;
        try {
            openDB();
            String sql = "delete from book where bno = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sno);
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
        return book;
    }

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    @Override
    public Book updateInfo(Book book) {
        try {
            openDB();
            String sql = "update book set bname = ?, author = ?, price = ?, press = ? where no = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(5, book.getBno());
            preparedStatement.setString(1, book.getBname());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setString(4, book.getPress());
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
        return book;
    }

    /**
     * 查找图书
     * @param book
     * @return
     */
    @Override
    public Book findInfo(Book book) {
        Book b = null;
        try {
            openDB();
            String sql = "select * from book where bno = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getBno());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                b = new Book();
                b.setBno(resultSet.getString("bno"));
                b.setBname(resultSet.getString("bname"));
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

    @Override
    public List<Book> findAllInfo() {
        List<Book> books = new ArrayList<>();
        try {
            openDB();
            String sql = "select * from book";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book b = new Book();
                b.setBno(resultSet.getString("book_no"));
                b.setBname(resultSet.getString("book_name"));
                b.setAuthor(resultSet.getString("author"));
                b.setPrice(resultSet.getDouble("price"));
                b.setPress(resultSet.getString("press"));
                books.add(b);
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
        return books;
    }
}
