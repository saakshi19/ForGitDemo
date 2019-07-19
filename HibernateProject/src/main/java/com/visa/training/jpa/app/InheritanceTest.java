package com.visa.training.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.CurrentAccount;
import com.visa.training.jpa.domain.SavingsAccount;

public class InheritanceTest {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SavingsAccount sa = new SavingsAccount(10000);
		CurrentAccount ca = new CurrentAccount(100000, 1000);
		
		
		em.persist(sa);
		em.persist(ca);
		tx.commit();
		
		Account unknownType = em.find(Account.class,sa.getId());
		System.out.println("Account type: "+unknownType.getClass().getName());
		em.close();
		System.exit(0);
}

}
