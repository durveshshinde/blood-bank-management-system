package com.bloodBank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blood_bank", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO requests(name,bloodgroup,city) VALUES (?,?,?)");

            ps.setString(1, req.getParameter("name"));
            ps.setString(2, req.getParameter("bloodgroup"));
            ps.setString(3, req.getParameter("city"));

            ps.executeUpdate();

            res.sendRedirect("dashboard.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
