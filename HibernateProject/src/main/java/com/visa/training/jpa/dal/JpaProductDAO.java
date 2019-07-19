package com.visa.training.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.visa.training.jpa.domain.Product;

public class JpaProductDAO {
	
	 public Product save(Product p) {
	        EntityManagerFactory emf = JpaUtil.getEmf();
	        EntityManager em = emf.createEntityManager();
	        try{
	            EntityTransaction tx = em.getTransaction();
	            tx.begin();
	            em.persist(p);
	            tx.commit();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            em.close();
	        }
	        return p;
	    }
	
	public Product findById(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			Product p = em.find(Product.class, id);
			return p;
		} finally {
			em.close();
		}
	}
	
	public void removeById(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Product p = em.find(Product.class, id);
			em.remove(p);
			tx.commit();
		}
		finally {
			em.close();
		}
	}
	
	public void update(int id,Product p) {
		EntityManagerFactory emf = JpaUtil.getEmf();
        EntityManager em = emf.createEntityManager();
		
        try{
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Product p1 = em.find(Product.class, id);
            p1.setName(p.getName());
            p1.setPrice(p.getPrice());
            p1.setQoh(p.getQoh());
            em.merge(p1);
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        
	}
	
	public List<Product> findAll(){
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		
		Query q = em.createQuery("select p from Product as p");
		List<Product> all = q.getResultList();
		em.close();
		return all;
		
	}
	
	public List<Product> findByPriceGreaterThan(float price){
		
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from Product as p where p.price > ?");
		q.setParameter(1, price);
		List<Product> all = q.getResultList();
		em.close();
		return all;
	}

}
