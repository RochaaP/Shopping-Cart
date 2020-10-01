package com.company.utill;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;


public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {
    }
    public static Connection getConnection() {
        if (connection == null) {
            String MySQLURL = "jdbc:mysql://localhost:3306/shoppingcart?";
            String databaseUserName = "root";
            String databasePassword = "";
            try {
                connection = DriverManager.getConnection(MySQLURL, databaseUserName, databasePassword);
                if (connection!= null){
                    System.out.println("Database connection is successful !!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
