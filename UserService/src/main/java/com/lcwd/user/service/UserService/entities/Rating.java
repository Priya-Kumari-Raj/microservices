package com.lcwd.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {
	
	private String ratingsId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
	

}
