package com.company.utill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseQuery {
    public void startConnection(){
        Connection con = DatabaseConnection.getConnection();
        Statement statement;
        ResultSet query;
        String q = "Select * from items";
        try {
            if (con != null) {
                statement = con.createStatement();
                query = statement.executeQuery(q);
                while (query.next()) {
                    System.out.println(query.getString("reg"));
                }
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addValues(String id, String name, int quantity) {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement;
        String addVals = "insert into items(id,name,quantity) values(?,?,?)";
        try {
            if (con != null) {
                preparedStatement = con.prepareStatement(addVals);
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setInt(3,quantity);
                preparedStatement.execute();
                preparedStatement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList getValues() {
        Connection con = DatabaseConnection.getConnection();
        Statement statement;
        ResultSet query = null;
        String getVals = "select * from items";
        ArrayList<Items> arrayList = new ArrayList<>();

        try {
            if (con != null) {
                statement = con.createStatement();
                query = statement.executeQuery(getVals);
                while (query.next()) {
                    Items items = new Items(
                            query.getString("id"),
                            query.getString("name"),
                            query.getInt("quantity")
                    );
                    arrayList.add(items);
                }
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
