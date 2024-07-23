package com.exchangeagency.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {

    private static final String DB_URL = "jdbc:sqlite:D:/data/exchange-agency.db"; // Update to your actual path

    public static void initialize() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        // Create table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS listings (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "category TEXT NOT NULL, " +
                                "name TEXT NOT NULL, " +
                                "features TEXT)";
        statement.execute(createTableSQL);

        // Insert sample data
        String insertDataSQL = "INSERT INTO listings (category, name, features) VALUES " +
                               "('Electronics', 'iPhone X', 'Brand: Apple, RAM:8GB, Model: iPhone X, Colour: Silver'), " +
                               "('Clothing', 'Top', 'Brand: Nike, Size: Large, Colour: Black'), " +
                               "('Furniture', 'IKEA Sofa', 'Brand: IKEA, Type: Sofa, Colour: Brown'), " +
                               "('Electronics', 'Console', 'Brand: Sony, Colour: gold, Model: play station 5'), " +
                               "('Furniture', 'IKEA Bookcase', 'Brand: IKEA, Type: Bookcase, Colour: white'), " +
                               "('Clothing', 'Shoes', 'Brand: Nike, Size:7, Colour: blue'), " +
                               "('Clothing', 'Jacket', 'Brand: Next, Size: Medium, Colour: blue'), " +
                               "('Furniture', 'DFS Chair', 'Brand: DFS, Type: chair, Colour: white'), " +
                               "('Electronics', 'Air Pods', 'Brand: Apple, Colour: white'), " +
                               "('Electronics', 'Samsung S20', 'Brand: Samsung, RAM:6GB, Model: S20, Colour: green'), " +
                               "('Electronics', 'Samsung S10', 'Brand: Samsung, RAM:3GB, Model: S10, Colour: black')";
        statement.executeUpdate(insertDataSQL);

        statement.close();
        connection.close();
    }
}
