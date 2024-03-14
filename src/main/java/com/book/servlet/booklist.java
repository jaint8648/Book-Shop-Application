package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booklist")
public class booklist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","9311229815");
				PreparedStatement pstmt=con.prepareStatement("select bookid,bookname,bookedition,bookprice from bookdata");
			      ResultSet rs = pstmt.executeQuery();
			 
			      pw.println("<body style='background-color: #f0f0f0;'>");
			      pw.println("<table border='2' align='center' style='background-color: yellow; border-collapse: collapse; width: 80%; margin: 20px auto;'>");
			      pw.println("<tr style='background-color: #f2f2f2;'>");
			      pw.println("<th style='padding: 10px;'>Book Id</th>");
			      pw.println("<th style='padding: 10px;'>Book Name</th>");
			      pw.println("<th style='padding: 10px;'>Book Edition</th>");
			      pw.println("<th style='padding: 10px;'>Book Price</th>");
			      pw.println("<th style='padding: 10px;'>Edit</th>");
			      pw.println("<th style='padding: 10px;'>Delete</th>");
			      pw.println("</tr>");
			      while (rs.next()) {
			          pw.println("<tr>");
			          pw.println("<td style='padding: 10px;'>" + rs.getInt(1) + "</td>");
			          pw.println("<td style='padding: 10px;'>" + rs.getString(2) + "</td>");
			          pw.println("<td style='padding: 10px;'>" + rs.getString(3) + "</td>");
			          pw.println("<td style='padding: 10px;'>" + rs.getString(4) + "</td>");
			          pw.println("<td style='padding: 10px;'><a href='editscreen?id=" + rs.getInt(1) + "' style='text-decoration: none; color: blue;'>Edit</a></td>");
			          pw.println("<td style='padding: 10px;'><a href='deleteurl?id=" + rs.getInt(1) + "' style='text-decoration: none; color: red;'>Delete</a></td>");
			          pw.println("</tr>");
			      }
			      pw.println("</table>");

			      
         	}
			
			catch(Exception e) {
				e.printStackTrace();
				pw.println("<h2>" + e.getMessage() + "</h2>");
			}
			pw.println("<br>");
			pw.println("<a href='index.html' style='text-decoration: none; color: black; display: block; width: 50px; height: 50px; border: 2px solid black; border-radius: 50%; text-align: center; line-height: 50px; background-color: #f2f2f2; margin: 20px auto;'>Home</a>");

			pw.println("</body>");
	}






	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
}
}
	
