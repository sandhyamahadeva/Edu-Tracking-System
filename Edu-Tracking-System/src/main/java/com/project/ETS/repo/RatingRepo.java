package com.project.ETS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ETS.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

}
