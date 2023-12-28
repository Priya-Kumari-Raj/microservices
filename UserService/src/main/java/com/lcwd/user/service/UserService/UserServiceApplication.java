package com.lcwd.user.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.external.service.RatingService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
		
		
		
		
	}
	
	

	
//	//test
//	
//	@Test
//	void contextLoads() {
//		
//	}
//	
//	@Autowired
//	private RatingService ratingService;
//	
//	void createRating() {
//		Rating rating = Rating.builder().rating(10).userId("").hotel("").feedback("This is created using feignClient").build();
//		Rating savedRating = ratingService.createRating(rating);
//		System.out.println("new rating created");
//	}
	
	

}
