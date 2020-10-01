package com.company;

import com.company.userinterface.UserInterface;
import com.company.utill.DatabaseConnection;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection.getConnection();

	    UserInterface userInterface = new UserInterface();
	    userInterface.launching();
    }
}
