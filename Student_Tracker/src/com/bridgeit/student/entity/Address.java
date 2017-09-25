package com.bridgeit.student.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String state;
	private String country;
	private String pinCode;
	private String city;
	private String landMark;
	private String street;

	public Address(String state, String country, String pinCode, String city, String landMark, String street) {
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.city = city;
		this.landMark = landMark;
		this.street = street;
	}

	public Address() {
		state = null;
		country = null;
		pinCode = null;
		city = null;
		landMark = null;
		street = null;

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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", country=" + country + ", pinCode=" + pinCode + ", city=" + city
				+ ", landMark=" + landMark + ", street=" + street + "]";
	}

}
