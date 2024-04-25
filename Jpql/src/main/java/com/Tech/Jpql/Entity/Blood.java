package com.Tech.Jpql.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Blood {
	
	@Id
	private Integer id;
	private String donarName;
	private String bloodGroup;
	private String contactNO;
	

}
