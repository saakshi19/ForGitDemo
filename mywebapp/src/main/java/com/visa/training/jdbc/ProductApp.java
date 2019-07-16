package com.visa.training.jdbc;

import java.sql.SQLException;
import java.util.List;

public class ProductApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ProductDAO dao = new ProductDAO();
		/*Product prod = new Product(5,"vew",4.0f,10);
		int generatedId = dao.save(prod);
		System.out.println("Created with id ="+generatedId);
		Product fromDB = dao.findById(generatedId);
		*/
		List<Product> all = dao.findAll();
		all.forEach(System.out::println);

	}

}
