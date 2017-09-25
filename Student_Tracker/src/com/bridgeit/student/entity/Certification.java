package com.bridgeit.student.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Certification {
	@Column(name="certi_name")
	private String name;
	@Column(name="certi_date")
	private String date;

	@Override
	public String toString() {
		return "Certification [name=" + name + ", date=" + date + "]";
	}

	public Certification() {
		name = null;
		date = null;
	}

	public Certification(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
