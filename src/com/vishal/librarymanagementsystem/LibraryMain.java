package com.vishal.librarymanagementsystem;

import java.io.IOException;

public class LibraryMain {

	public static void main(String[] args) {
		
		LibraryPresentation libraryPresentation = new LibraryPresentation();
		try {
			libraryPresentation.showMenu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
