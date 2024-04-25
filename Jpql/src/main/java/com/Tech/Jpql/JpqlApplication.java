package com.Tech.Jpql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Tech.Jpql.Controller.BloodController;
import com.Tech.Jpql.Model.BloodDTO;

@SpringBootApplication
public class JpqlApplication implements CommandLineRunner {

	@Autowired
	private BloodController bloodController;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// getAlldonarInfo();
		// getdonarInfoByName();
		//getcontactNobyName();
		//addInfo();
		//updateInfo();
		deleteInfo();
	}

	public void getAlldonarInfo() throws Exception {

		try {
			List<BloodDTO> res = bloodController.getAllDonar();

			for (BloodDTO bloodDTO : res) {
				System.out.println("id" + " " + bloodDTO.getId());
				System.out.println(bloodDTO.getDonarName());
				System.out.println(bloodDTO.getBloodGroup());
				System.out.println(bloodDTO.getContactNO());
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public void getdonarInfoByName() throws Exception {

		try {

			BloodDTO bloodDTO = bloodController.getDonarInfoByName("arun");

			System.out.println("id" + " " + bloodDTO.getId());
			System.out.println(bloodDTO.getDonarName());
			System.out.println(bloodDTO.getBloodGroup());
			System.out.println(bloodDTO.getContactNO());

		} catch (Exception e) {
			throw e;
		}
	}

	public void getdonarInfobyName() throws Exception {
		try {
			BloodDTO bloodDTO = bloodController.getDonarInfoBybloodGroup("a+");

			System.out.println(bloodDTO.getId());
			System.out.println(bloodDTO.getBloodGroup());
			System.out.println(bloodDTO.getContactNO());
			System.out.println(bloodDTO.getDonarName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void addInfo() throws Exception {

		try {
	
			BloodDTO bloodDTO=new BloodDTO();
			bloodDTO.setId(100);
			bloodDTO.setDonarName("raja");
			bloodDTO.setBloodGroup("b+");
			bloodDTO.setContactNO("13456787654");
			bloodController.addNewInfo(bloodDTO);
	


		} catch (Exception e) {
			throw e;
		}
	}
	public void updateInfo() throws Exception {

		try {
	
			BloodDTO bloodDTO=new BloodDTO();
		
			bloodDTO.setDonarName("raja");
			bloodDTO.setBloodGroup("A+ve");
			bloodController.updateInfo(bloodDTO);
	


		} catch (Exception e) {
			throw e;
		}
	}

public void deleteInfo() throws Exception {

	try {

		BloodDTO bloodDTO=new BloodDTO();
		bloodController.deleteInfo("raja");



	} catch (Exception e) {
		throw e;
	}
}
}
