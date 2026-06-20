package com.bloodBank;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", "root", "root");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM donors WHERE email=? AND password=?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				// session create
				HttpSession session = req.getSession();
				session.setAttribute("user", email);

				// redirect dashboard
				res.sendRedirect("dashboard.html");

			} else {
				res.sendRedirect("login.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
