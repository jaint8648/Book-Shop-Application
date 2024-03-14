package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editurl")
public class editurl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  
		  int id = Integer.parseInt(req.getParameter("id"));
		  
		  String bookname=req.getParameter("bookname");
		  String bookedition=req.getParameter("bookedition");
		  String bookprice=req.getParameter("bookprice");
		  
		  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","9311229815");
				PreparedStatement pstmt=con.prepareStatement("update bookdata set bookname=?,bookedition=?,bookprice=? where bookid=?");
				pstmt.setString(1,bookname);
				pstmt.setString(2,bookedition);
				pstmt.setString(3,bookprice);
				pstmt.setInt(4,id);
				int count=pstmt.executeUpdate();
				if(count == 1) {
					pw.println("<h1 style='text-align: center; color: darkblue;'>You are Edited Sucessfully</h1>");
					
				}
				else {
		                pw.println("<h2>You are not Edited Sucessfully<h2>");
		            }
			}
        	
			catch(Exception e) {
				e.printStackTrace();
				pw.println("<h2>" + e.getMessage() + "</h2>");
			}
			pw.println("<style>");
			pw.println("a {");
			pw.println("    display: inline-block;");
			pw.println("    padding: 10px 20px;");
			pw.println("    text-decoration: none;");
			pw.println("    color: white;");
			pw.println("    background-color: #007bff;");
			pw.println("    border-radius: 5px;");
			pw.println("    margin: 5px;");
			pw.println("}");
			pw.println("</style>");

			pw.println("<a href='index.html'>Home</a>");
			pw.println("<a href='booklist'>Book List</a>");
	}



	
}

	
