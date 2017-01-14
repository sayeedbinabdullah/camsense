package com.graphity.dao;


import java.util.List;

import com.graphity.model.AdminProduct;
import com.graphity.model.Cart;
import com.graphity.model.MemberDetail;
public interface CartDao
{
	
	 public void insertCart(Cart c1);
     public List<Cart> get(String id); 
     public List<AdminProduct> getParticularProd(int id); 
     public List<MemberDetail> getMember(String id);



}
