package com.bloodBank;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBlood")
public class AddBloodServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String blood = req.getParameter("bloodgroup");
		int units = Integer.parseInt(req.getParameter("units"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", "root", "root");

			PreparedStatement ps = con.prepareStatement("INSERT INTO blood_stock(bloodgroup, units) VALUES (?, ?)");

			ps.setString(1, blood);
			ps.setInt(2, units);

			ps.executeUpdate();

			res.sendRedirect("dashboard.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
