package com.Tech.Jpql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tech.Jpql.Model.BloodDTO;
import com.Tech.Jpql.Repo.BloodRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BloodServiceImpl implements BloodService {
	
	@Autowired
	private BloodRepo bloodRepo;

	@Override
	public BloodDTO getDonarInfoByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return bloodRepo.getDonarInfoByName(name);
	}

	@Override
	public List<BloodDTO> getAllDonar() throws Exception {
		// TODO Auto-generated method stub
		return bloodRepo.getAllDonar();
	}

	@Override
	public BloodDTO getDonarInfoBybloodGroup(String bloodGroup) throws Exception {
		// TODO Auto-generated method stub
		return bloodRepo.getDonarInfoBybloodGroup(bloodGroup);
	}

	@Override
	public void addNewInfo(BloodDTO bloodDTO) throws Exception {
		bloodRepo.addNewInfo(bloodDTO);
		
	}

	@Override
	public void updateInfo(BloodDTO bloodDTO) throws Exception {
		bloodRepo.updateInfo(bloodDTO);
		
	}

	@Override
	public void delteInfo(String name) throws Exception {
	bloodRepo.delteInfo(name);
		
	}

}
