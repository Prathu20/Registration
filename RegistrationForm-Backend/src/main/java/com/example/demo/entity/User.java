package com.example.demo.entity;

import java.util.Arrays;
import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="User")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Lob
	@Column(name = "images_data", columnDefinition = "LONGBLOB")
	private byte[] imagesData;
	
	@Transient
	private String base64Content;  
    
    private String firstName;
    private String lastName;
    private String gender;
    private String education;
    private String country;
    private String state;
    private String city;
    private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImagesData() {
		return imagesData;
	}
	public void setImagesData(byte[] imagesData) {
		this.imagesData = imagesData;
	}
	public String getBase64Content() {
		return base64Content;
	}
	public void setBase64Content(String base64Content) {
		this.base64Content = base64Content;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User(int id, byte[] imagesData, String base64Content, String firstName, String lastName, String gender,
			String education, String country, String state, String city, String description) {
		super();
		this.id = id;
		this.imagesData = imagesData;
		this.base64Content = base64Content;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.education = education;
		this.country = country;
		this.state = state;
		this.city = city;
		this.description = description;
	}
	
	public User(byte[] imagesData, String base64Content, String firstName, String lastName, String gender,
			String education, String country, String state, String city, String description) {
		super();
		this.imagesData = imagesData;
		this.base64Content = base64Content;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.education = education;
		this.country = country;
		this.state = state;
		this.city = city;
		this.description = description;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
    
    
}