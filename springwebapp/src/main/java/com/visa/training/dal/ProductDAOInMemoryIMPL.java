package com.visa.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.visa.training.domain.Product;


//@Repository
public class ProductDAOInMemoryIMPL implements ProductDAO{
	
	
	int idSequence;
	Map<Integer,Product> data = new HashMap<>();
	
	
	@Override
	public Product save(Product p) {
		int id= ++idSequence;
		p.setId(id);
		data.put(id,p);
		return p;
	}
	
	@Override
	public Product findById(int id) {
		return data.get(id);
	}
	
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(data.values());
	}
	@Override
	public void update(Product p) {
		data.put(p.getId(), p);
		
		
	}
	@Override
	public void remove(int id) {
		data.remove(id);
		
	}
	
}
