package com.bloodBank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession(false);
		String email = (String) session.getAttribute("user");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", "root", "root");

			PreparedStatement ps = con
					.prepareStatement("UPDATE donors SET fullname=?, contact=?, city=? WHERE email=?");

			ps.setString(1, req.getParameter("fullname"));
			ps.setString(2, req.getParameter("contact"));
			ps.setString(3, req.getParameter("city"));
			ps.setString(4, email);

			ps.executeUpdate();

			res.sendRedirect("profile");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
