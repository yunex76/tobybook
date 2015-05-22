package com.yunex.firstspring;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yunex.firstspring.dao.DaoFactory98;
import com.yunex.firstspring.dao.UserDao;
import com.yunex.firstspring.domain.User;

/**
 * 토비 spring3 책 99페이지 소스
 * @author Nam YunHyeok
 * @since 2015-05-21
 */
public class AppTest99 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	System.out.println("AppTest99 run.............");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory98.class);
    	UserDao dao = context.getBean("userDao", UserDao.class);
    	
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
    }
}
