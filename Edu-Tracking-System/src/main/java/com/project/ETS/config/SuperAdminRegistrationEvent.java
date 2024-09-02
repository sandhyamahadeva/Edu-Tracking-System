package com.project.ETS.config;

import java.util.List;
import java.util.UUID;

import com.project.ETS.model.Super_Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.project.ETS.enums.UserRole;
import com.project.ETS.model.Super_Admin;
import com.project.ETS.model.User;
import com.project.ETS.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SuperAdminRegistrationEvent {

	private UserRepository userRepo;

	@Value("${SUPER_ADMIN_EMAIL}")
	private String superAdminEmail;

	public SuperAdminRegistrationEvent(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}



	@EventListener(classes = ApplicationReadyEvent.class)
	public void registerSuperAdmin() {
		log.info("checking if super admin is present");
		List<User> superAdmins= userRepo.findByRole(UserRole.SUPER_ADMIN);
		if(superAdmins.isEmpty()) {
			log.info("super admin is not present creating one");
			User user = new Super_Admin();
			user.setEmail(superAdminEmail);
			user.setPassword(UUID.randomUUID().toString());
			user.setRole(UserRole.SUPER_ADMIN);
			user.setUserName("admin");
			userRepo.save(user);
		}
		else
			log.info("super admin present with email: "+superAdmins.get(0).getEmail());
	}

}
