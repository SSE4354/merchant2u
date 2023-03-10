package com.merchant2u.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	private static final String URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	private static Connection connection = null;

	public static Connection openConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("unhandled", e);
			} catch (SQLException e) {
				throw new RuntimeException("unhandled", e);
			}
			return connection;
		}
	}
}
