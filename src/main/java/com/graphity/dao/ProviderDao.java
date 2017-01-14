package com.graphity.dao;

import com.graphity.model.Provider;

public interface ProviderDao {
	
	public int sortId();
	public void UpRecord(Provider prv);
	public Provider DispRecord(int pid);
	public void deleteProvider(int pid);
	public String listProvider();
	public void saveProvider(Provider prov);
	

}
