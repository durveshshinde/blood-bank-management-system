package com.bloodBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String blood = req.getParameter("bloodgroup");
        String city = req.getParameter("city");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blood_bank", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM donors WHERE bloodgroup=? AND city=?");

            ps.setString(1, blood);
            ps.setString(2, city);

            ResultSet rs = ps.executeQuery();

            // UI OUTPUT
            out.println("<h2>Search Results</h2>");
            out.println("<table border='1' style='margin:auto;'>");
            out.println("<tr><th>Name</th><th>Email</th><th>Contact</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("fullname") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("contact") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
