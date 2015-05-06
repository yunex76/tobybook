package com.yunex.firstspring;

import java.sql.SQLException;

import com.yunex.firstspring.dao.UserDao;
import com.yunex.firstspring.domain.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	UserDao dao = new UserDao();
    	
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
