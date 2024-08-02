package com.spring.jobportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recruiter_profile")
public class RecruiterProfile {

	@Id
	private int userAccount;
	
	@OneToOne
	@JoinColumn(name = "useraccount__id")
	@MapsId
	private Users userId;
	
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String country;
	private String company;
	
	@Column(nullable = true, length = 64)
	private String profilePhoto;

	public RecruiterProfile() {
	}

	public RecruiterProfile(int userAccount, Users userId, String firstName, String lastName, String city,
			String state, String country, String company, String profilePhoto) {
		super();
		this.userAccount = userAccount;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.company = company;
		this.profilePhoto = profilePhoto;
	}

	public int getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Override
	public String toString() {
		return "ReccruiterProfile [userAccount=" + userAccount + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", company=" + company + ", profilePhoto=" + profilePhoto + "]";
	}
	
}
