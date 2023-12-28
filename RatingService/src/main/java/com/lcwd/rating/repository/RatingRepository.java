package com.lcwd.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lcwd.rating.entities.Rating;

@EnableJpaRepositories
public interface RatingRepository extends JpaRepository<Rating, String>{
	
	//custom finder methods
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
	
}
