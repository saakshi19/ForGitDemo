
package com.visa.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDAO;

@WebServlet({ "/addProduct", "/listProducts","/removeProduct" })
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        
        if(request.getRequestURI().endsWith("addProduct")) {
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int qoh = Integer.parseInt(request.getParameter("qoh"));
            Product p = new Product(name, price, qoh);
            dao.save(p);
        }else if(request.getRequestURI().endsWith("removeProduct")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.remove(id);
        }
        
        List<Product> productList = dao.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("product.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

