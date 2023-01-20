package com.revature.poms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			ResourceBundle rb = ResourceBundle.getBundle("project");
			String dburl = rb.getString("dburl");
			String username = rb.getString("username");
			String password = rb.getString("password");

			try {
				Class.forName(rb.getString("driver"));
				connection = DriverManager.getConnection(dburl, username, password);
			} catch (ClassNotFoundException e) {
				System.out.println("Class Not Found");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return connection;
	}

}
