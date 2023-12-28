package com.lcwd.hotel.services.Impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import com.lcwd.hotel.services.Exception.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		
		
		
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel with given id not found!!"));
	}
	

	
}
