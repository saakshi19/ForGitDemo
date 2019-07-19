package com.visa.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.visa.training.dal.ProductDAO;
import com.visa.training.dal.ProductDAOInMemoryIMPL;
import com.visa.training.service.ProductService;
import com.visa.training.service.ProductServiceImpl;
import com.visa.training.ui.ProductConsoleUI;

@Configuration
@ComponentScan(basePackages = "com.visa.training")
public class ProductAppConfiguration {
	
	//Tell spring which are the beans ,.. how dependency injection should be (wiring info)
	
	/*@Bean
	public ProductDAO dao() {
		
		return new ProductDAOInMemoryIMPL();
		
	}
	
	//@Bean
	public ProductService service() {
		
		ProductServiceImpl service =  new ProductServiceImpl();
		service.setDao(dao());
		return service;
	
	}
	
	//@Bean
	public ProductConsoleUI ui() {
		
		ProductConsoleUI ui = new ProductConsoleUI();
		ui.setService(service());
		return ui;
	}
	*/

}
