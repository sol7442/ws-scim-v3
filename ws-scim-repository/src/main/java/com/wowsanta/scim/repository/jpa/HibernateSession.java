package com.wowsanta.scim.repository.jpa;

import org.hibernate.Session;

import com.wowsanta.scim.repository.ScimSession;
import com.wowsanta.scim.repository.ScimTransaction;

public class HibernateSession implements ScimSession {
	final Session session;
	public HibernateSession(Session session) {
		this.session = session;
	}
	@Override
	public ScimTransaction beginTransaction() {
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
