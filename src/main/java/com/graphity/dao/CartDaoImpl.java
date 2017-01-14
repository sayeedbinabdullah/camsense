package com.graphity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.graphity.model.AdminProduct;
import com.graphity.model.Cart;
import com.graphity.model.MemberDetail;

@Repository
public class CartDaoImpl implements CartDao
{
	@Autowired
	private SessionFactory sessionFactory;

	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	 public void insertCart(Cart c1)
		{
			//creating session object    
			Session session=sessionFactory.openSession();    
			  
			//creating transaction object    
			Transaction t=session.beginTransaction();    
			        
			session.save(c1);//persisting the object    
			    
			t.commit();//transaction is commited    
			session.close();  
			
		}

	 @Transactional
		public List<Cart> get(String id) {
			//creating session object    
			Session session=sessionFactory.openSession();    
					    
			//creating transaction object    
			Transaction t=session.beginTransaction();    
			String hql = "from"+" Cart"+" where cartuser=" + "'"+id+"'";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Cart> listType = (List<Cart>) query.list();
			
			if (listType != null && !listType.isEmpty()) {
				
					return listType;
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}


		public List<AdminProduct> getParticularProd(int id) {
			//creating session object    
					Session session=sessionFactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			String hql = "from"+" AdminProduct "+" where aproductId=" +id;
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<AdminProduct> listType = (List<AdminProduct>) query.list();
			
			if (listType != null && !listType.isEmpty()) {
				
							return listType;
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}

		
		@Transactional
		public List<MemberDetail> getMember(String id) {
			//creating session object    
					Session session=sessionFactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			String hql = "from"+" MemberDetails "+" where memberName=" +"'"+id+"'";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<MemberDetail> listType = (List<MemberDetail>) query.list();
			
			if (listType != null && !listType.isEmpty()) {
				
				return listType;
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}

		
		
	


}
