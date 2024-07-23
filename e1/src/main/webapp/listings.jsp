<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exchangeagency.model.Listing" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .container {
            max-width: 1000px;
            margin: 20px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-bottom: 20px;
            font-size: 16px;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Listings</h1>
        <a href="addListing.jsp" class="btn">Add Listing</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th>Features</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Listing> listings = (List<Listing>) request.getAttribute("listings");
                    if (listings != null) {
                        for (Listing listing : listings) {
                %>
                <tr>
                    <td><%= listing.getId() %></td>
                    <td><%= listing.getCategory() %></td>
                    <td><%= listing.getName() %></td>
                    <td><%= listing.getFeatures() %></td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">No listings available</td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
