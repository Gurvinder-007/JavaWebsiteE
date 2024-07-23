package com.exchangeagency.dao;

import com.exchangeagency.model.Listing;
import com.exchangeagency.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListingDAO {

    public List<Listing> getAllListings() {
        List<Listing> listings = new ArrayList<>();
        String sql = "SELECT * FROM listings";

        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Listing listing = new Listing();
                listing.setId(resultSet.getInt("id"));
                listing.setCategory(resultSet.getString("category"));
                listing.setName(resultSet.getString("name"));
                listing.setFeatures(resultSet.getString("features"));
                listings.add(listing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listings;
    }

    public void addListing(Listing listing) {
        String sql = "INSERT INTO listings (category, name, features) VALUES (?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, listing.getCategory());
            preparedStatement.setString(2, listing.getName());
            preparedStatement.setString(3, listing.getFeatures());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
