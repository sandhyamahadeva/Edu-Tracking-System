package com.project.ETS.enums;

import java.util.List;

public enum UserRole {
	
	SUPER_ADMIN(List.of(
			Privilege.WRITE_ADMIN,
			Privilege.WRITE_HR,
			Privilege.WRITE_BATCH,
			Privilege.WRITE_STUDENT,
			Privilege.WRITE_TRAINER,
			Privilege.WRITE_SCHEDULE,
			Privilege.WRITE_MOCK,
			
			
			Privilege.READ_USER,
			Privilege.READ_TECH_REPORT,
			Privilege.READ_SCHEDULE,
			Privilege.READ_REQUIREMENT,
			Privilege.READ_REATING,
			Privilege.READ_MOCK,
			Privilege.READ_BATCH
			)),
	
	ADMIN(List.of(
			Privilege.WRITE_HR,
			Privilege.WRITE_BATCH,
			Privilege.WRITE_STUDENT,
			Privilege.WRITE_TRAINER,
			Privilege.WRITE_SCHEDULE,
			Privilege.WRITE_MOCK,
			Privilege.WRITE_ADMIN,
			
			Privilege.READ_USER,
			Privilege.READ_TECH_REPORT,
			Privilege.READ_SCHEDULE,
			Privilege.READ_REQUIREMENT,
			Privilege.READ_REATING,
			Privilege.READ_MOCK,
			Privilege.READ_BATCH
			
			)),
	
	
	HR(List.of(
			Privilege.READ_USER,
			Privilege.READ_TECH_REPORT,
			Privilege.READ_SCHEDULE,
			Privilege.READ_REQUIREMENT,
			Privilege.READ_REATING,
			Privilege.READ_MOCK,
			Privilege.READ_BATCH,
			
			Privilege.WRITE_REQUIREMENT,
			Privilege.WRITE_RATING,
			Privilege.WRITE_STUDENT,
			Privilege.WRITE_HR
			)),
	
	
	TRAINER(List.of(
			Privilege.WRITE_RATING,
			Privilege.WRITE_MOCK,
			Privilege.WRITE_TECH_REPORT,
			Privilege.WRITE_TRAINER,
			
			Privilege.READ_USER,
			Privilege.READ_TECH_REPORT,
			Privilege.READ_SCHEDULE,
			Privilege.READ_REQUIREMENT,
			Privilege.READ_REATING,
			Privilege.READ_MOCK,
			Privilege.READ_BATCH
			)),
	
	STUDENT(List.of(
			Privilege.READ_USER,
			Privilege.WRITE_STUDENT
			));
	
	private List<Privilege> privileges;
	
	private UserRole(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	public List<Privilege> getPrivileges(){
		return privileges;
	}

}
