package com.graphity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.graphity.model.MemberDetail;

@Repository("memberdaoimpl")
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }*/
	 
	@Transactional
	public void saveorupdate(MemberDetail mem) 
	{
		System.out.println("I am in user Dao Class"+sessionFactory);
		
		Session sess = sessionFactory.getCurrentSession();
		System.out.println("session="+sess);
		//predefined function
		sess.save(mem);
		
		System.out.println("user data successfully done");
		
	}

	
	@SuppressWarnings("unchecked")
	public List<MemberDetail> viewcustomerd() {
	
		System.out.println("view custome details");
		Session sess = sessionFactory.getCurrentSession();
		System.out.println("session="+sess);
		List<MemberDetail> list = sess.createCriteria(MemberDetail.class).list(); 	
		return list;
	}

}
