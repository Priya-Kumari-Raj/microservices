package com.lcwd.rating.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name ="rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String ratingId;
	private String  userId;
	private String hotelId;
	private int rating;
	private String feedback;
	

}
