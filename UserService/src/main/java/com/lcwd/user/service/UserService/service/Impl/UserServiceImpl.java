package com.lcwd.user.service.UserService.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.external.service.HotelService;
import com.lcwd.user.service.UserService.repository.UserRepository;
import com.lcwd.user.service.UserService.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	//Using RestTemplate we are communicating two microservices
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	// using feign Client we are communicating two microservices
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		// generate unique userid
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// implementing RATING SERVICE CALL: USING REST TEMPLATE
		return userRepository.findAll();
	}
	//get single user

	@Override
	public User getUser(String userId) {
		//get user from database with the help of user Repository
		User  user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user given Id is not found on server!!"+ userId));
		
		// fetch rating of the above user from RATING SERVICE
	Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(), Rating[].class);
		//Rating rating = forEntity.getBody();
	logger.info("response:{}",ratingsOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		//ratings.forEach((e)->System.out.println(e));
	List<Rating> ratingList = ratings.stream().map(rating->{
		
			//api call to hotel service to get the hotel
			//http://localhost:8083/hotels/ratingId
	
		//ResponseEntity<Hotel>  forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(),Hotel.class);
	//Hotel hotel =forEntity.getBody();
		
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
		//logger.info("response status code: {}",forEntity.getStatusCode());
		// set the hotel to rating
	
		rating.setHotel(hotel);
			//return the rating
		return rating;
		
	}).collect(Collectors.toList());
	user.setRatings(ratingList);
	
		return user;
		
	}

}
