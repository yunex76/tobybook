package com.yunex.firstspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", "");
		
		return c;
	}
}
