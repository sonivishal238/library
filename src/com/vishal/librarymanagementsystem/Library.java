package com.vishal.librarymanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Library implements ILibrary, Serializable {

	static Scanner scanner = new Scanner(System.in);
	static String path;
	static String directoryName;
	static String rootFolder;

	static {
		System.out.println("Enter the path : ");
		Library.path = scanner.next();

		System.out.println("Enter directory name: ");
		directoryName = scanner.next();
		rootFolder = path + directoryName;
		File f1 = new File(rootFolder);
		f1.mkdirs();

	}

	// method to add new book to library
	@Override
	public void addBook(Book book) throws IOException {

		String authorPath = Library.rootFolder + "\\" + book.getAuthorName();
		File f2 = new File(authorPath);
		boolean bool2 = f2.mkdir();
//		if (bool2) {
//			System.out.println("Folder with author name created successfully");
//		} else {
//			System.out.println("Error Found in creation of Folder with author name!");
//		}

		String finalFilePath = authorPath + "\\" + book.getIsbnNumber() + ".txt";
		FileOutputStream fileOutputStream = new FileOutputStream(finalFilePath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(book);
		System.out.println("File create successfully");

		fileOutputStream.close();
//		objectOutputStream.flush();
		objectOutputStream.close();
	}

	// method to show book details
	@Override
	public void showBookDetails(Book book, String authorName, String isbnNumber) throws IOException, ClassNotFoundException {
		
		String authorPath = Library.rootFolder + "\\" + authorName;
		String finalFilePath = authorPath + "\\" + isbnNumber + ".txt";
		FileInputStream fileInputStream = new FileInputStream(finalFilePath);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Object readObject = objectInputStream.readObject();
		Book myBook = (Book) readObject;
		System.out.println(myBook.toString());
		fileInputStream.close();
		objectInputStream.close();
		

	}

	@Override
	public void updateBook(String authorName, String isbnNumber) throws IOException, ClassNotFoundException {
		
		String authorPath = Library.rootFolder + "\\" + authorName;
		String finalFilePath = authorPath + "\\" + isbnNumber + ".txt";
		FileInputStream fileInputStream = new FileInputStream(finalFilePath);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Object readObject = objectInputStream.readObject();
		Book myBook = (Book) readObject;
		System.out.println("book details before updating: ");
		System.out.println(myBook.toString());
		fileInputStream.close();
		objectInputStream.close();
		
		FileOutputStream fileOutputStream = new FileOutputStream(finalFilePath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		double cost;
		String publisher;
		int publishingYear;
		
		System.out.println("Enter New cost: ");
		cost = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter New Publisher: ");
		publisher = scanner.nextLine();
		
		System.out.println("Enter New publishing year: ");
		publishingYear = scanner.nextInt();
		
		Book updatedBook = new Book();
		updatedBook.setAuthorName(authorName);
		updatedBook.setIsbnNumber(isbnNumber);
		updatedBook.setBookName(myBook.getBookName());
		updatedBook.setCost(cost);
		updatedBook.setPublisher(publisher);
		updatedBook.setPublishingYear(publishingYear);
		
		
		objectOutputStream.writeObject(updatedBook);
		System.out.println("File updated successfully and details are:");
		
		System.out.println(updatedBook.toString());

		fileOutputStream.close();
//		objectOutputStream.flush();
		objectOutputStream.close();
		
		
	}

	@Override
	public void deleteBook( String authorName, String isbnNumber) {
		String authorPath = Library.rootFolder + "\\" + authorName;
		String finalFilePath = authorPath + "\\" + isbnNumber + ".txt";
		
		File deleteBook = new File(finalFilePath);
		if(deleteBook.delete())
        {
            System.out.println("Book record deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the record");
        }
	}

}
