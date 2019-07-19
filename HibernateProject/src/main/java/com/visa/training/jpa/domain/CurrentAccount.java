package com.visa.training.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account{
	
	@Column(name="OD_limit")
	float ODLimit;

	public CurrentAccount() {
		super();
	}

	public float getODLimit() {
		return ODLimit;
	}

	public void setODLimit(float oDLimit) {
		ODLimit = oDLimit;
	}

	public CurrentAccount(float balance,float ODLimit) {
		super(balance);
		this.ODLimit= ODLimit;
	}
	
	
}
