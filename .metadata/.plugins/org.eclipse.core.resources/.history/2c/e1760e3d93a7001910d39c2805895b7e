package com.visa.training.jdbc;

import java.sql.*;

public class JdbcUtil {
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			//establishing connection: Load driver class
			Class.forName("com.mysql.jdbc.Driver");
			//connection
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "visa", "secret");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
		
	}
}
