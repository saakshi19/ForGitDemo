package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO class has CRUD + Query Methods()
public class ProductDAO {
	
	
	public int save(Product toBeSaved) throws SQLException {
		
		int generatedId=0; 
		
		Connection c = JdbcUtil.getConnection();
		/*
		String sql="INSERT into product Values("+toBeSaved.getId()+",'"+toBeSaved.getName()+"',"+toBeSaved.getPrice()+","+toBeSaved.getQoh()+")";
		System.out.println(sql);
		Statement s = c.createStatement();
		s.executeUpdate(sql);
		*/
		//Another way of saving data
		
		PreparedStatement smt = c.prepareStatement("INSERT into product Values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		smt.setInt(1,toBeSaved.getId());
		smt.setString(2,toBeSaved.getName());
		smt.setFloat(3,toBeSaved.getPrice());
		smt.setInt(4,toBeSaved.getQoh());
		smt.executeUpdate();
		
		ResultSet keys = smt.getGeneratedKeys();
		keys.next();
		generatedId=keys.getInt(1);
		
		
		System.out.println("Product details inserted" );
		c.close();//can also throw an exception
		return generatedId;
	}
	
	public Product findById(int id)  {
		//read based on ID
		Product p = null;
		try(Connection c = JdbcUtil.getConnection()){
			
			PreparedStatement s = c.prepareStatement("Select * from product where product_id=?");
			s.setInt(1, id);
			ResultSet r=s.executeQuery();
			System.out.println(r);
			
			if(r.next()) {
			p = mapRow(r);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return p;
		
		
	}

	private Product mapRow(ResultSet r) throws SQLException {
		Product p;
		p=new Product();
		p.setId(r.getInt(1));
		p.setName(r.getString(2));
		p.setPrice(r.getFloat(3));
		p.setQoh(r.getInt(4));
		return p;
	}
	
	public List<Product> findAll(){
		
		List<Product> all = new ArrayList<>();
		try(Connection c = JdbcUtil.getConnection()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("Select * from product");
		
			while(rs.next()) {
				Product aProduct = mapRow(rs);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return all;
	}
	/*
	public void remove(int id) {
		//remove/delete 
		Connection c = JdbcUtil.getConnection();
		
	}
	public void update(Product updated) {
		//update 
		Connection c = JdbcUtil.getConnection();
		
	}
	*/
}
