package com.visa.training.jpa.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String firstname;
	String middlename;
	String lastname;
	java.sql.Date Dateofjoin;
	
	public Customer() {	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", Dateofjoin=" + Dateofjoin + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public java.sql.Date getDateofjoin() {
		return Dateofjoin;
	}

	public void setDateofjoin(java.sql.Date dateofjoin) {
		Dateofjoin = dateofjoin;
	}

	public Customer(String firstname, String middlename, String lastname, Date dateofjoin) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		Dateofjoin = dateofjoin;
	}

		
}
