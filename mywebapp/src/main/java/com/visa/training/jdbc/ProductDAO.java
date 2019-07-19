

package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO class has CRUD + Query methods
public class ProductDAO {
    
    public int save(Product p) {
        int generatedId = 0;
        try(Connection c = JdbcUtil.getConnection()) {
            //String sql = "insert into product values("+p.getId()+",'"+p.getName()+"',"+p.getPrice()+","+p.getQoh()+")";
            //System.out.println(sql);
            String pSql = "insert into product(product_name,product_price,product_qoh) values(?,?,?)";
            PreparedStatement s = c.prepareStatement(pSql,Statement.RETURN_GENERATED_KEYS);
            //s.setInt(1, p.getId());
            s.setString(1, p.getName());
            s.setFloat(2, p.getPrice());
            s.setInt(3, p.getQoh());
            s.executeUpdate();
            
            ResultSet keys = s.getGeneratedKeys();
            keys.next();
            generatedId = keys.getInt(1);
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return generatedId;
    }
    
    public Product findById(int id) {
        Product p = null;
        try(Connection c = JdbcUtil.getConnection()){
            PreparedStatement s = c.prepareStatement("select * from product where product_id=?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                p = mapRow(rs);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    private Product mapRow(ResultSet rs) throws SQLException {
        Product p;
        p = new Product();
        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setPrice(rs.getFloat(3));
        p.setQoh(rs.getInt(4));
        return p;
    }
    
    public List<Product> findAll(){
        List<Product> all = new ArrayList<>();
        try(Connection c = JdbcUtil.getConnection()){
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from product");
            while(rs.next()) {
                Product aProduct = mapRow(rs);
                all.add(aProduct);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public void remove(int id) {
        try(Connection c = JdbcUtil.getConnection()){
            Statement s = c.createStatement();
            s.executeUpdate("delete from product where product_id="+id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /*public void remove(int id) {
        //delete
    }
    public void update(Product updated) {
        //update
    }*/

}


