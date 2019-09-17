package com.wowsanta.scim.repository.jpa;

import org.hibernate.Session;

import com.wowsanta.scim.repository.RepositorySession;
import com.wowsanta.scim.repository.RepositoryTransaction;

public class HibernateSession implements RepositorySession {
	final Session session;
	public HibernateSession(Session session) {
		this.session = session;
	}
	@Override
	public RepositoryTransaction beginTransaction() {
		return new HibernateTransaction(this.session.beginTransaction());
	}
	@Override
	public void close() {
		this.session.close();
	}
	
	@Override
	public void save(Object object) {
		this.session.save(object);
	}
	
	
}
