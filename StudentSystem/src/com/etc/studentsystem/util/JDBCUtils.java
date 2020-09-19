package com.etc.studentsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	public static Connection Connect() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String URL="jdbc:mysql://localhost:3306/myyt";
		String username="root";
		String userpassword="";
		Connection connection=DriverManager.getConnection(URL,username,userpassword);
		return connection;
	}
	public static void Release(Connection connection,Statement statement,ResultSet resultSet){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

 