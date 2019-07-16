package com.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountServiceTest {

	@Test
	public void createAccount_returns_valid_id_when_balance_gt_minbal() {
		//Arrange
		AccountService service = new AccountService();
		//Act
		int id = service.createNewAccount("SA", 10001);
		//Assert
		assertTrue(id>0);
	}

}
