package com.lcwd.user.service.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity(name ="users")

public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	
	
	@Transient
	private List<Rating> ratings= new ArrayList<>();


}
