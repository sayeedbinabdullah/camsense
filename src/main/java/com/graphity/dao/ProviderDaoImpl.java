package com.graphity.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.graphity.model.Provider;

@Repository

public class ProviderDaoImpl implements ProviderDao{
	
	@Autowired
	 SessionFactory sessionFactory;
	public void saveProvider(Provider prov)
	{
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(prov);
		session.getTransaction().commit();
		session.close();
		
		
	}
	@SuppressWarnings("rawtypes")
	public String listProvider()
	{
		
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		List li=se.createQuery("from Provider").list();
		Gson gson = new Gson();
	
		String jsontyplist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		return jsontyplist ;
	}
	public void deleteProvider(int pid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 Provider prv=(Provider)se.get(Provider.class,pid);
		 se.delete(prv);
		 se.getTransaction().commit();
		 se.close();
		
	}
	public Provider DispRecord(int pid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 Provider prv=(Provider)se.get(Provider.class,pid);
		return prv;
		
	}
	public void UpRecord(Provider prv)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 int pid=prv.getProvId();
		 Provider prvobj=(Provider)se.get(Provider.class,pid);
		prvobj.setProvName(prv.getProvName());
		prvobj.setContactNo(prv.getContactNo());
		prvobj.setProvAdd(prv.getProvAdd());

		 se.update(prvobj);
		 se.getTransaction().commit();
	
		 se.close();
		
		
	}
	public int sortId()
	{
		
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Provider order by provId DESC");
		query.setMaxResults(1);
		Provider last = (Provider) query.uniqueResult();
		int id=last.getProvId();
		return id;
	}

}
