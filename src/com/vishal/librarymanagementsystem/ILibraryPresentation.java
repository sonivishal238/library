package com.vishal.librarymanagementsystem;

import java.io.IOException;

public interface ILibraryPresentation {

	void showMenu() throws IOException, ClassNotFoundException;
	void performMenu(int choice) throws IOException, ClassNotFoundException;
}
