package com.bridgeit.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userlist")
public class User {
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "phone")
	private String phone;
	@Column(name = "password")
	private String password;
	@Column(name = "gender")
	private String gender;

	public User() {
		fullname = null;
		email = null;
		phone = null;
		password = null;
		gender = null;
	}

	public User(String email, String fullname, String phone, String password, String gender) {

		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
