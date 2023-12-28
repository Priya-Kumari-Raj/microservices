package com.lcwd.user.service.UserService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.UserService.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	//get
	
	

	//post
	@PostMapping("/rating")
	public Rating createRating(Rating values);
	
	//put
	@PutMapping("/rating/{ratingId}")
	public Rating updateRatingRating(@PathVariable("ratingId") String ratingId, Rating rating);
	
	

	//delete
	@DeleteMapping("/rating/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);

}
