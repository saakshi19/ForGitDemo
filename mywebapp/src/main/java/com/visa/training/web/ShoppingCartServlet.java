package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/addBooks", "/addCars", "/addBikes" })
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		if(url.endsWith("addBooks")) {
			String [] selectedBooks= request.getParameterValues("books");
			session.setAttribute("selectedBooks",selectedBooks);
			request.getRequestDispatcher("car.html").forward(request,response);
			
		}else if(url.endsWith("addCars")) {
			String [] selectedCars= request.getParameterValues("cars");
			session.setAttribute("selectedCars",selectedCars);
			request.getRequestDispatcher("bikes.html").forward(request,response);
		}
		else if(url.endsWith("addBikes")) {
			String [] selectedBikes= request.getParameterValues("bikes");
			String [] selectedBooks = (String[]) session.getAttribute("selectedBooks");
			String [] selectedCars = (String[]) session.getAttribute("selectedCars");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("h4>Selected books</h4>");
			out.println("<ul>");
			Stream.of(selectedBooks).map(s->"<li>"+s+"</li>").forEach(out::println);
            out.println("</ul>");
            
            out.println("<h4>Selected Cars</h4>");
            out.println("<ul>");
            Stream.of(selectedCars).map(s->"<li>"+s+"</li>").forEach(out::println);
            out.println("</ul>");
            
            out.println("<h4>Selected Bikes</h4>");
            out.println("<ul>");
            Stream.of(selectedBikes).map(s->"<li>"+s+"</li>").forEach(out::println);
            out.println("</ul>");
            
            
            out.println("</body></html>");
            
            session.invalidate();
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
