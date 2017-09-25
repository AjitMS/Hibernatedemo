package com.bridgeit.student.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Book {

	public Book() {
		bookName = null;
		bookAuthor = null;
	}

	public Book(String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	private String bookName;
	private String bookAuthor;

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
}
