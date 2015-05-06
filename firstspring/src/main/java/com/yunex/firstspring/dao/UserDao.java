package com.yunex.firstspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yunex.firstspring.domain.User;

public class UserDao {

	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", "");
		
		PreparedStatement ps = c.prepareStatement("insert into users (id, name, password) values (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		System.out.println(ps.toString());
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", "");

		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();
		rs.next();

		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
	
		return user;
	}
}
