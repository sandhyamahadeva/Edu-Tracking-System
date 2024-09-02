package com.project.ETS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ETS.model.Batch;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo  extends JpaRepository<Batch, String> {
	

}
