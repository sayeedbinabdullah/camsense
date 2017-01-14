package com.graphity.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.graphity.config.AppContConfig;
import com.graphity.dao.MemberDao;
import com.graphity.model.Type;
import com.graphity.model.Provider;
import com.graphity.model.MemberDetail;

public class TestCases {

static AnnotationConfigApplicationContext context;
	
	public TestCases()
	{
		 context= new AnnotationConfigApplicationContext(AppContConfig.class);
		 context.scan("com.graphity");
	}
	public static void main(String[] args) 
	{	
		try{
			System.out.println("main started..");
			TestCases tc = new TestCases();
			
			MemberDetail member = new MemberDetail();
			Type typ = new Type();
			Provider prov = new Provider();
		/*user.setName("rama");
		user.setUserName("niit"); 
		user.setPassword("niit@123");
		user.setEmail("ganesh@yahoo.com");
		user.setMobile("4546");
		System.out.println("done=="+user);
		//UserDao userdao = new UserDaoImpl();
		UserDao userdao = (UserDao)context.getBean("userdaoimpl");
		System.out.println("userdao="+userdao);
		userdao.saveorupdate(user);*/
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("main ended...");
}
}
