package com.ttnd.workshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loo")
public class Loo {

	@Id  //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//unique
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Location")
	private String Location;
	
	@Column(name = "State")
	private String State;
	
	@Column(name = "City")
	private String City;
	
	@Column(name = "Area")	
	private String Area;

	@Column(name = "Rating")	
	private Integer Rating=0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public Integer getRating() {
		return Rating;
	}

	public void setRating(Integer rating) {
		Rating = rating;
	}

	@Override
	public String toString() {
		return "Loo [id=" + id + ", Location=" + Location + ", State=" + State + ", City=" + City + ", Area=" + Area
				+ "]";
	}
	
}
