package com.emp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con = null;

	static {

		try {
			Class.forName(DBPropertiesI.DB_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {

			System.out.println(e);
			e.printStackTrace();
		}

	}

	public static Connection getConnectionInstance() throws SQLException {

		if (con == null) {
			con = DriverManager.getConnection(DBPropertiesI.URL, DBPropertiesI.DB_CONNECTION_USERNAME,
					DBPropertiesI.DB_CONNECTION_PASSWORD);
		}
		return con;
	}
}
