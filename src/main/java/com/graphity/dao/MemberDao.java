package com.graphity.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.graphity.model.MemberDetail;

@Repository
public interface MemberDao {
	
	public void saveorupdate(MemberDetail mem);
	public List<MemberDetail> viewcustomerd(); 

}
