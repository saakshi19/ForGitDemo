package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.ProductDAO;
import com.visa.training.jdbc.Product;


@WebServlet("/product")
public class ProductWeb extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1= request.getParameter("id");
		String s2= request.getParameter("name");
		String s3= request.getParameter("price");
		String s4= request.getParameter("qoh");
		
		int generatedId =0;
		int id = Integer.parseInt(s1);
		float price = Float.parseFloat(s3);
		int qoh = Integer.parseInt(s4);
		ProductDAO dao = new ProductDAO();
		Product prod = new Product(s2,price,qoh);
		
		generatedId = dao.save(prod);
		
		PrintWriter out = response.getWriter();
		out.println("Submitted  with id "+generatedId);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
