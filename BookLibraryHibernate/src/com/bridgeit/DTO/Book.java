package com.bridgeit.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userbooks")
public class Book {

	@Column(name = "bookname")
	private String bookName;
	@Column(name = "bookauthor")
	private String bookAuthor;
	@Column(name = "bookcategory")
	private String bookCategory;
	@Column(name = "bookdescription")
	private String bookDescription;

	public Book(String bookName, String bookAuthor, String bookCategory, String bookDescription) {

		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
		this.bookDescription = bookDescription;
	}

	public Book() {

		bookName = null;
		bookAuthor = null;
		bookCategory = null;
		bookDescription = null;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
}
