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


@WebServlet("/editscreen")
public class editscreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  int id=Integer.parseInt(req.getParameter("id"));
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","9311229815");
				PreparedStatement pstmt=con.prepareStatement("select bookname,bookedition,bookprice from bookdata where bookid=?");
				pstmt.setInt(1,id);  
				ResultSet rs = pstmt.executeQuery();
			      rs.next();
//		            pw.println("<form action='editurl?id=" + id + "' method='post'>");
//		            pw.println("<table align='center'>");
//		            pw.println("<tr>");
//		            pw.println("<td>Book Name</td>");
//		            pw.println("<td><input type='text' name='bookname' value='" + rs.getString(1) + "'></td>");
//		            pw.println("</tr>");
//		            pw.println("<tr>");
//		            pw.println("<td>Book Edition</td>");
//		            pw.println("<td><input type='text' name='bookedition' value='" + rs.getString(2) + "'></td>");
//		            pw.println("</tr>");
//		            pw.println("<tr>");
//		            pw.println("<td>Book Price</td>");
//		            pw.println("<td><input type='text' name='bookprice' value='" + rs.getString(3) + "'></td>");
//		            pw.println("</tr>");
//		            pw.println("<tr>");
//		            pw.println("<td><input type='submit' value='Edit'></td>");
//		            pw.println("<td><input type='reset' value='cancel'></td>");
//		            pw.println("</tr>");
//		            pw.println("</table>");
//		            pw.println("</form>");
			      pw.println("<body style='background-color: #f0f0f0;'>");
			      pw.println("<form action='editurl?id=" + id + "' method='post' style='margin-top: 20px;'>");
			      pw.println("<table border='1' align='center' style='border-collapse: collapse; margin-top:5%'>");
			      pw.println("<tr>");
			      pw.println("<td style='padding: 10px;'>Book Name</td>");
			      pw.println("<td><input type='text' name='bookname' value='" + rs.getString(1) + "' style='padding: 5px; border: 1px solid #ccc; border-radius: 5px;'></td>");
			      pw.println("</tr>");
			      pw.println("<tr>");
			      pw.println("<td style='padding: 10px;'>Book Edition</td>");
			      pw.println("<td><input type='text' name='bookedition' value='" + rs.getString(2) + "' style='padding: 5px; border: 1px solid #ccc; border-radius: 5px;'></td>");
			      pw.println("</tr>");
			      pw.println("<tr>");
			      pw.println("<td style='padding: 10px;'>Book Price</td>");
			      pw.println("<td><input type='text' name='bookprice' value='" + rs.getString(3) + "' style='padding: 5px; border: 1px solid #ccc; border-radius: 5px;'></td>");
			      pw.println("</tr>");
			      pw.println("<tr>");
			      pw.println("<td colspan='2' style='text-align: center; padding-top: 10px;'><input type='submit' value='Edit' style='padding: 5px 20px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;'>");
			      pw.println("<input type='reset' value='Cancel' style='padding: 5px 20px; background-color: #dc3545; color: white; border: none; border-radius: 5px; cursor: pointer; margin-left: 10px;'></td>");
			      pw.println("</tr>");
			      pw.println("</table>");
			      pw.println("</form>");

			
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
	
