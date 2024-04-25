package com.Tech.Jpql.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tech.Jpql.Entity.Blood;
import com.Tech.Jpql.Model.BloodDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class BloodRepoImpl implements BloodRepo{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BloodDTO getDonarInfoByName(String name) throws Exception {
		Query query=entityManager.createQuery("Select u from Blood u where u.donarName=?1");
		query.setParameter(1, name);
	    Blood blood= (Blood) query.getSingleResult();
	    
		BloodDTO bloodDTO=new BloodDTO();
		bloodDTO.setId(blood.getId());
		bloodDTO.setDonarName(blood.getDonarName());
		bloodDTO.setBloodGroup(blood.getBloodGroup());
		bloodDTO.setContactNO(blood.getContactNO());
	
	
		return 	bloodDTO;
	}

	@Override
	public List<BloodDTO> getAllDonar() throws Exception {
		Query query=entityManager.createQuery("Select u from Blood u");
		
		List<BloodDTO> bloodDTOs=new ArrayList<BloodDTO>();
		Iterable<Blood> dataFromDb=query.getResultList();
		for(Blood blood:dataFromDb) {
			BloodDTO bloodDTO=new BloodDTO();
			bloodDTO.setId(blood.getId());
			bloodDTO.setDonarName(blood.getDonarName());
			bloodDTO.setBloodGroup(blood.getBloodGroup());
			bloodDTO.setContactNO(blood.getContactNO());
			bloodDTOs.add(bloodDTO);
		}
		return bloodDTOs;
	}

	@Override
	public BloodDTO getDonarInfoBybloodGroup(String bloodGroup) throws Exception {
		Query query=entityManager.createQuery("Select u from Blood u where u.bloodGroup=?1");
		query.setParameter(1,bloodGroup);
		Blood blood=(Blood) query.getSingleResult();
		BloodDTO bloodDTO=new BloodDTO();
		bloodDTO.setId(blood.getId());
		bloodDTO.setContactNO(blood.getContactNO());
		bloodDTO.setDonarName(blood.getDonarName());
		bloodDTO.setBloodGroup(blood.getBloodGroup());
		System.out.println(bloodDTO.getContactNO());
		return bloodDTO;
	}

	@Override
	public void addNewInfo(BloodDTO bloodDTO) throws Exception {
		Query query=entityManager.createQuery("insert into Blood(donarName,bloodGroup,contactNO,id) values(?1,?2,?3,?4)");
		query.setParameter(1,bloodDTO.getDonarName());
		query.setParameter(2,bloodDTO.getBloodGroup());
		query.setParameter(3,bloodDTO.getContactNO());
		query.setParameter(4,bloodDTO.getId());
		query.executeUpdate();
	}

	@Override
	public void updateInfo(BloodDTO bloodDTO) throws Exception {
		Query query=entityManager.createQuery("update Blood u set u.bloodGroup=?2 where u.donarName=?1");
		query.setParameter(1, bloodDTO.getDonarName());
		query.setParameter(2, bloodDTO.getBloodGroup());
		query.executeUpdate();
		
	}

	@Override
	public void delteInfo(String name) throws Exception {
	Query query=entityManager.createQuery("delete from Blood u where u.donarName=?1");
	query.setParameter(1, name);
	query.executeUpdate();
		
	}

}
