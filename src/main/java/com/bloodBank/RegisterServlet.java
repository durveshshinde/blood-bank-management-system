package com.bloodBank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {

	        String name = req.getParameter("fullname");
	        String email = req.getParameter("email");
	        String contact = req.getParameter("contact");
	        String blood = req.getParameter("bloodgroup");
	        String gender = req.getParameter("gender");
	        String city = req.getParameter("city");
	        String password = req.getParameter("password");

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/blood_bank", "root", "root");

	            PreparedStatement ps = con.prepareStatement(
	                    "INSERT INTO donors(fullname,email,contact,bloodgroup,gender,city,password) VALUES (?,?,?,?,?,?,?)");

	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, contact);
	            ps.setString(4, blood);
	            ps.setString(5, gender);
	            ps.setString(6, city);
	            ps.setString(7, password);

	            ps.executeUpdate();

	            // ✅ redirect to login page
	            res.sendRedirect("login.html");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}  

	}
