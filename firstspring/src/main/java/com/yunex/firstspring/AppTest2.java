package com.yunex.firstspring;

import java.sql.SQLException;

import com.yunex.firstspring.dao.ConnectionMaker;
import com.yunex.firstspring.dao.DConnectionMaker;
import com.yunex.firstspring.dao.UserDao;
import com.yunex.firstspring.domain.User;

/**
 * Hello world!
 *
 */
public class AppTest2 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	System.out.println("AppTest2 run.............");
    	
    	ConnectionMaker connectionMaker = new DConnectionMaker();
    	UserDao dao = new UserDao(connectionMaker);
    	
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
