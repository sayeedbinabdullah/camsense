package com.graphity.dao;

import com.graphity.model.Type;

public interface TypeDao {

	public void delete(String id);
	public void saveOrUpdate(Type type) ;
	public String  list();
	public Type get(String id);
}
