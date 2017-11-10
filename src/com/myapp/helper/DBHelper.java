package com.myapp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	public static Connection connection=null;
	
	public static Connection createConnection() throws ClassNotFoundException,
	SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(
				"jdbc:mysql://localhost/myapp", "root","root");
		return connection;
	}
	
	public static void closeConnection() throws SQLException{
		connection.close();
	}

}
