package com.vishal.librarymanagementsystem;

import java.io.IOException;
import java.io.Serializable;
import java.time.Year;
import java.util.Scanner;

public class LibraryPresentation implements ILibraryPresentation, Serializable {

	Scanner scanner = new Scanner(System.in);

	@Override
	public void showMenu() throws IOException, ClassNotFoundException {
		while (true) {

			System.out.println("Enter Choice: ");
			System.out.println("1. Add New Book:");
			System.out.println("2. Show Details of a Book :");
			System.out.println("3. Update Details of a book: ");
			System.out.println("4. Delete a book: ");
			System.out.println("5. Exit ");

			int choice = scanner.nextInt();
			performMenu(choice);
		}

	}

	@Override
	public void performMenu(int choice) throws IOException, ClassNotFoundException {

		String authorName;
		String isbnNumber;
		String bookName;
		double cost;
		String publisher;
		int publishingYear;

		Library library = new Library();
		Book book = new Book();

		switch (choice) {
		case 1:

			System.out.println("Enter author name: ");
			authorName = scanner.next();

			System.out.println("Enter Isbn Number: ");
			isbnNumber = scanner.next();
			scanner.nextLine();

			System.out.println("Enter Book Name: ");
			bookName = scanner.nextLine();

			System.out.println("Enter Book Cost: ");
			cost = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("Enter Book Publisher: ");
			publisher = scanner.nextLine();
			
			
			System.out.println("Enter Book Publishing Year: ");
			publishingYear = scanner.nextInt();
			

			book.setAuthorName(authorName);
			book.setIsbnNumber(isbnNumber);
			book.setBookName(bookName);
			book.setCost(cost);
			book.setPublisher(publisher);
			book.setPublishingYear(publishingYear);
			library.addBook(book);

			break;

		case 2:
			scanner.nextLine();
			System.out.println("Enter author name: ");
			authorName = scanner.nextLine();

			System.out.println("Enter ISBN Number: ");
			isbnNumber = scanner.next();

			library.showBookDetails(book, authorName, isbnNumber);
			break;

		case 3:
			scanner.nextLine();
			System.out.println("Enter author name: ");
			authorName = scanner.nextLine();

			System.out.println("Enter ISBN Number: ");
			isbnNumber = scanner.nextLine();

			library.updateBook(authorName, isbnNumber);
			break;

		case 4:
			scanner.nextLine();
			System.out.println("Enter author name: ");
			authorName = scanner.nextLine();

			System.out.println("Enter ISBN Number: ");
			isbnNumber = scanner.nextLine();

			library.deleteBook(authorName, isbnNumber);
			break;

		case 5:
			System.out.println("Thanks for using library management system.");
			System.exit(1);

		default:
			System.out.println("Please enter a correct choice.");
		}

	}

}
