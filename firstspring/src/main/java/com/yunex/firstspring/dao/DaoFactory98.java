package com.yunex.firstspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 토비 spring3 책 98페이지 소스
 * @author Nam YunHyeok
 * @since 2015-05-21
 */
@Configuration
public class DaoFactory98 {

	@Bean
	public UserDao userDao() {
		
    	return new UserDao(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
