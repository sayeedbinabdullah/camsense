package com.graphity.dao;

import com.graphity.model.AdminProduct;

public interface AdminProductDao {

	public void addProdSave(AdminProduct adprod);
	public String listAdProd();
	public void deleteAdProd(int apid);
	public void upAdProd(AdminProduct apd);
	public AdminProduct DispRecord(int apid);
	public int sortId();
	public String lisTypWise(String typ);

}
