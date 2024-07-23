package com.exchangeagency.servlet;

import com.exchangeagency.dao.ListingDAO;
import com.exchangeagency.model.Listing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListListingsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListingDAO listingDAO = new ListingDAO();
        List<Listing> listings = listingDAO.getAllListings();

        request.setAttribute("listings", listings);
        request.getRequestDispatcher("listings.jsp").forward(request, response);
    }
}


