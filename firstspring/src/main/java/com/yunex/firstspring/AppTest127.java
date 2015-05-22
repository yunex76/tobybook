package com.yunex.firstspring;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yunex.firstspring.dao.CountingConnectionMaker;
import com.yunex.firstspring.dao.CountingDaoFactory;
import com.yunex.firstspring.dao.UserDao;
import com.yunex.firstspring.domain.User;

/**
 * 토비 spring3 책 127페이지 소스
 * @author Nam YunHyeok
 * @since 2015-05-22
 */
public class AppTest127 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	System.out.println("AppTest127 run.............");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
    	UserDao dao = context.getBean("userDao", UserDao.class);
    	
    	// DAO 사용 코드
    	User user = new User();
    	user.setId("whiteship");
    	user.setName("백기선");
    	user.setPassword("married");
    	
    	dao.add(user);
    	
    	System.out.println(user.getId() + " 등록 성공!!");
    	
    	User user2 = dao.get(user.getId());
    	System.out.println(user2.getName());
    	System.out.println(user2.getPassword());
    	
    	System.out.println(user2.getId() + " 조회 성공!!!");

    	// 
    	CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
    	System.out.println("Connection counter (before) : " + ccm.getCounter());
    	
    	Connection c = ccm.makeConnection();
    	System.out.println("Connection counter (after)  : " + ccm.getCounter());
    }
}
