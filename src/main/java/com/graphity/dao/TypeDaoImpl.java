package com.graphity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.graphity.model.Type;

@Repository

public class TypeDaoImpl implements TypeDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory)
	{
		this.sessionfactory= sessionfactory;
	}
	
	public String  list()
	{
		//creating session object    
				Session session=sessionfactory.openSession();    
				    
				//creating transaction object    
				Transaction t=session.beginTransaction();    
		@SuppressWarnings("unchecked")
		List<Type> listType = (List<Type>) session.createCriteria(Type.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		Gson gson=new Gson();
		String data=gson.toJson(listType);
		t.commit();//transaction is commited    
		session.close();  
		
		return data;
	}
	
	
	
	
		public void saveOrUpdate(Type type) {
		//creating session object    
				Session session=sessionfactory.openSession();    
				    
				//creating transaction object    
				Transaction t=session.beginTransaction();    
		session.saveOrUpdate(type);
		
		t.commit();//transaction is commited    
		session.close();  
		
	
	}
		
		
		public void delete(String id) {
			//creating session object    
					Session session=sessionfactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
					Type TypeToDelete = new Type();
					TypeToDelete.setId(id);
			session.delete(TypeToDelete);
			t.commit();//transaction is commited    
			session.close();  
			
		}


		public Type get(String id) {
			//creating session object    
					Session session=sessionfactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			String hql = "from"+" Type"+" where id=" + "'"+id+"'";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Type> listType = (List<Type>) query.list();
			
			if (listType != null && !listType.isEmpty()) {
				return listType.get(0);
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}

}
