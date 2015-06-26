package com.yunex.firstspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:D:\\kpmspm_pdev\\tools\\sqlite-jdbc-3.8.10.1\\data\\data.db", "sa", "");
		
		return c;
	}
}
