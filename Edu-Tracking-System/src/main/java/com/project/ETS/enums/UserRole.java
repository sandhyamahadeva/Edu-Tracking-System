package com.project.ETS.enums;

import java.util.List;

public enum UserRole {

	SUPER_ADMIN(List.of(Privilege.READ_BATCH,Privilege.READ_MOCK,Privilege.READ_RATING,Privilege.READ_REQUIREMENT,
			Privilege.READ_SHEDULE,Privilege.READ_TECH_REPORT,Privilege.READ_USER,Privilege.WRITE_ADMIN,Privilege.WRITE_HR,
			Privilege.WRITE_STUDENT,Privilege.WRITE_TRAINER)),
	ADMIN(List.of(Privilege.READ_BATCH,Privilege.READ_MOCK,Privilege.READ_RATING,Privilege.READ_REQUIREMENT,
			Privilege.READ_SHEDULE,Privilege.READ_TECH_REPORT,Privilege.READ_USER,Privilege.WRITE_ADMIN,
			Privilege.WRITE_HR,Privilege.WRITE_STUDENT,Privilege.WRITE_TRAINER)),
	HR(List.of(Privilege.WRITE_HR,Privilege.WRITE_REQUIREMENT,Privilege.READ_RATING,Privilege.READ_BATCH,
			Privilege.READ_REQUIREMENT,Privilege.WRITE_SHEDULE,Privilege.READ_SHEDULE,Privilege.READ_USER,
			Privilege.READ_MOCK,Privilege.READ_TECH_REPORT)),
	TRAINER(List.of(Privilege.WRITE_TRAINER,Privilege.READ_BATCH,Privilege.WRITE_MOCK,Privilege.WRITE_TECH_REPORT,Privilege.READ_USER,Privilege.READ_MOCK,
			Privilege.READ_RATING,Privilege.WRITE_RATING)),
	STUDENT(List.of(Privilege.READ_USER,Privilege.READ_MOCK,Privilege.READ_RATING,Privilege.READ_REQUIREMENT,
			Privilege.READ_SHEDULE,Privilege.READ_TECH_REPORT,Privilege.WRITE_STUDENT));


	private List<Privilege> privileges;

	private UserRole(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	private List<Privilege> getPrivileges(){
		return privileges;
	}


}
