package com.project.ETS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ETS.enums.UserRole;
import com.project.ETS.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	List<User> findByRole(UserRole role);

}
