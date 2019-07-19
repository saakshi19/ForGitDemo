package com.visa.training.jpa.app;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.Product;

public class ProductJpaApp {

		public static void main(String[] args) {
			JpaProductDAO dao = new JpaProductDAO();
			Product test = new Product("hibernate",9999,1000);
			//Product saved = dao.save(test);
			//System.out.println(saved);
			//dao.removeById(41);
			//System.out.println(dao.findById(41));
			//dao is receiving detatched object
			Product test1 = new Product("Hibernate1",10000,10);
			dao.update(45, test1);
			System.out.println(dao.findById(45));
			
			
			
			System.exit(0);
		}
}
