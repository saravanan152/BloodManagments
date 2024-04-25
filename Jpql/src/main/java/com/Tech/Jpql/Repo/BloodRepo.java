package com.Tech.Jpql.Repo;

import java.util.List;

import com.Tech.Jpql.Model.BloodDTO;

public interface BloodRepo {
	
	public BloodDTO getDonarInfoByName(String name) throws Exception;
	public List<BloodDTO> getAllDonar() throws Exception;
	public BloodDTO getDonarInfoBybloodGroup(String bloodGroup) throws Exception; 
    public void addNewInfo(BloodDTO bloodDTO)  throws Exception;
    public void updateInfo(BloodDTO bloodDTO)  throws Exception;
    public void delteInfo(String name)  throws Exception;
}
