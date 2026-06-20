package com.bloodBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet  extends HttpServlet {
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse res)
	            throws IOException {

	        HttpSession session = req.getSession(false);

	        if (session == null) {
	            res.sendRedirect("login.html");
	            return;
	        }

	        String email = (String) session.getAttribute("user");

	        res.setContentType("text/html");
	        PrintWriter out = res.getWriter();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/blood_bank", "root", "root");

	            PreparedStatement ps = con.prepareStatement(
	                    "SELECT * FROM donors WHERE fullname=?");

	            ps.setString(1, email);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                out.println("<h2>Profile Details</h2>");
	                out.println("<table border='1'>");

	                out.println("<tr><td>Name</td><td>" + rs.getString("fullname") + "</td></tr>");
	                out.println("<tr><td>Email</td><td>" + rs.getString("email") + "</td></tr>");
	                out.println("<tr><td>Contact</td><td>" + rs.getString("contact") + "</td></tr>");
	                out.println("<tr><td>Blood Group</td><td>" + rs.getString("bloodgroup") + "</td></tr>");
	                out.println("<tr><td>City</td><td>" + rs.getString("city") + "</td></tr>");

	                out.println("</table>");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
