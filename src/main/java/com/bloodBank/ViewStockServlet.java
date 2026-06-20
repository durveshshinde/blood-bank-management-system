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

@WebServlet("/viewStock")
public class ViewStockServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", "root", "root");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM blood_stock");

			ResultSet rs = ps.executeQuery();

			out.println("<h2>Available Blood Stock</h2>");
			out.println("<table border='1' style='margin:auto;'>");
			out.println("<tr><th>Blood Group</th><th>Units</th></tr>");

			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("bloodgroup") + "</td>");
				out.println("<td>" + rs.getInt("units") + "</td>");
				out.println("</tr>");
			}

			out.println("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
