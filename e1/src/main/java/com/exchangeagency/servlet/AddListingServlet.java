package com.exchangeagency.servlet;

import com.exchangeagency.dao.ListingDAO;
import com.exchangeagency.model.Listing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddListingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String features = request.getParameter("features");

        Listing listing = new Listing();
        listing.setCategory(category);
        listing.setName(name);
        listing.setFeatures(features);

        ListingDAO listingDAO = new ListingDAO();
        listingDAO.addListing(listing);

        response.sendRedirect("listings.jsp");
    }
}


