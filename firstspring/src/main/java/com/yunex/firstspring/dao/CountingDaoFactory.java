package com.yunex.firstspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 토비 spring3 책 126페이지 소스
 * @author Nam YunHyeok
 * @since 2015-05-22
 */
@Configuration
public class CountingDaoFactory {

	@Bean
	public UserDao userDao() {
		
    	return new UserDao(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
}
