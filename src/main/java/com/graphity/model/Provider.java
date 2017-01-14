package com.graphity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Provider {
	
	@Id
	@GeneratedValue
	private int provId;
	@Column
	private String provName;
	@Column
	private String provAdd;
	@Column
	private String contactNo;
	public Provider()
	{
		
	}
	public int getProvId() {
		return provId;
	}
	public void setProvId(int provId) {
		this.provId = provId;
	}
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public String getProvAdd() {
		return provAdd;
	}
	public void setProvAdd(String provAdd) {
		this.provAdd = provAdd;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
