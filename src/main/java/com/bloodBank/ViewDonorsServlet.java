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

@WebServlet("/viewDonors")
public class ViewDonorsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", "root", "root");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM donors");

			ResultSet rs = ps.executeQuery();

			out.println("<h2>Donor List</h2>");
			out.println("<table border='1' style='margin:auto;'>");
			out.println("<tr><th>Name</th><th>Email</th><th>Blood</th><th>City</th><th>Action</th></tr>");

			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("fullname") + "</td>");
				out.println("<td>" + rs.getString("email") + "</td>");
				out.println("<td>" + rs.getString("bloodgroup") + "</td>");
				out.println("<td>" + rs.getString("city") + "</td>");
				out.println("<td><a href='deleteDonor?email=" + rs.getString("email") + "'>Delete</a></td>");
				out.println("</tr>");
			}

			out.println("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
