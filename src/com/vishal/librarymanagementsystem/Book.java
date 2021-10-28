package com.vishal.librarymanagementsystem;

import java.io.Serializable;

public class Book implements Serializable{

	private String authorName;
	private String isbnNumber;
	private String bookName;
	private double cost;
	private String publisher;
	private int publishingYear;

	public Book(String authorName, String isbnNumber, String bookName, double cost, String publisher,
			int publishingYear) {
		this.authorName = authorName;
		this.isbnNumber = isbnNumber;
		this.bookName = bookName;
		this.cost = cost;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
	}

	public Book() {
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	@Override
	public String toString() {
		return "[authorName=" + authorName + ", isbnNumber=" + isbnNumber + ", bookName=" + bookName
				+ ", cost=" + cost + ", publisher=" + publisher + ", publishingYear=" + publishingYear + "]";
	}
}
