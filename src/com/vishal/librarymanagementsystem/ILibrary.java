package com.vishal.librarymanagementsystem;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILibrary {

	public void addBook(Book book) throws FileNotFoundException, IOException;
	public void showBookDetails(Book book,String authorName, String isbnNumber) throws FileNotFoundException, IOException, ClassNotFoundException;
	public void updateBook(String authorName, String isbnNumber) throws FileNotFoundException, IOException, ClassNotFoundException;
	public void deleteBook(String authorName, String isbnNumber);
}
