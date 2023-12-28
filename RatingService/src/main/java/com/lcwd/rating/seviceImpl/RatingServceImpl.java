package com.lcwd.rating.seviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;

import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.services.RatingService;

@Service
public class RatingServceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	
	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}
	

}
