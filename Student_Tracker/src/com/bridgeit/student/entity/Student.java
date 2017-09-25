
package com.bridgeit.student.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Embedded
	private Address address;
	@Embedded
	@Column(name = "certification")
	private Certification certification;

	@ElementCollection(fetch=FetchType.EAGER)//gets entire list and other data
	//@ElementCollection(fetch=FetchType.Lazy)//gets only tier 1 Data like int String
	private List<Book> bookList = new ArrayList<>();
	
	public Collection<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Address getAddress() {
		return address;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Student(String firstName, String lastName, Address address, Certification certification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.certification = certification;
	}

	public Student(String firstName, String lastName, Address address, Certification certification,
			List<Book> bookList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.certification = certification;
		this.bookList = bookList;
	}

	public Student() {
		firstName = null;
		lastName = null;
		address = null;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", Certification=" + certification + "]";
	}
}
