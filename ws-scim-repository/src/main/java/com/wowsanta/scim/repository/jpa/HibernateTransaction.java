package com.wowsanta.scim.repository.jpa;

import org.hibernate.Transaction;

import com.wowsanta.scim.repository.RepositoryTransaction;

public class HibernateTransaction implements RepositoryTransaction {

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
