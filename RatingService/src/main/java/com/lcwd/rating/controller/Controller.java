package com.lcwd.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.seviceImpl.RatingServceImpl;


@RestController
@RequestMapping("/rating")
public class Controller {
	
	@Autowired
	private RatingServceImpl ratingServiceImpl;
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServiceImpl.create(rating));
	}
	
	
	//get all 
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingServiceImpl.getRatings());
	}
	
	//get all
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingServiceImpl.getRatingsByUserId(userId));
	}
	
	// get all
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingServiceImpl.getRatingsByHotelId(hotelId));
	}
	
	
	
	

}
