package com.Tech.Jpql.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.Tech.Jpql.Model.BloodDTO;
import com.Tech.Jpql.Repo.BloodRepo;
import com.Tech.Jpql.Service.BloodService;

@Controller
public class BloodController  {
	
	@Autowired
	private BloodService bloodService;


	public BloodDTO getDonarInfoByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return bloodService.getDonarInfoByName(name);
	}

	public List<BloodDTO> getAllDonar() throws Exception {
		// TODO Auto-generated method stub
		return bloodService.getAllDonar();
	}
	public BloodDTO getDonarInfoBybloodGroup(String bloodGroup) throws Exception {
		// TODO Auto-generated method stub
		return bloodService.getDonarInfoBybloodGroup(bloodGroup);

}
	
	public void addNewInfo(BloodDTO bloodDTO) throws Exception {
		bloodService.addNewInfo(bloodDTO);
		
	}


	public void updateInfo(BloodDTO bloodDTO) throws Exception {
		bloodService.updateInfo(bloodDTO);
		
	}
	
	public void deleteInfo(String name) throws Exception {
	bloodService.delteInfo(name);
		
	}

}