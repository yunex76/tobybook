package com.yunex.firstspring.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 토비 spring3 책 124페이지 소스
 * @author Nam YunHyeok
 * @since 2015-05-22
 */
public class CountingConnectionMaker implements ConnectionMaker {

	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}
	
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {

		this.counter++;
		return realConnectionMaker.makeConnection();
	}

	public int getCounter() {
		return this.counter;
	}
}
