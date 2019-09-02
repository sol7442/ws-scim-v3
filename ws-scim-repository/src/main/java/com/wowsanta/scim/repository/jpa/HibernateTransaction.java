package com.wowsanta.scim.repository.jpa;

import org.hibernate.Transaction;

import com.wowsanta.scim.repository.ScimTransaction;

public class HibernateTransaction implements ScimTransaction {

	private final Transaction transaction;
	public HibernateTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	@Override
	public void commit() {
		this.transaction.commit();
	}
	@Override
	public void rollback() {
		this.transaction.rollback();		
	}
	
	
	
}
