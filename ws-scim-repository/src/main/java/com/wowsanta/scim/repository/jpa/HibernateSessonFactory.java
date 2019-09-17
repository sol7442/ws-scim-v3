package com.wowsanta.scim.repository.jpa;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wowsanta.scim.repository.RepositorySession;
import com.wowsanta.scim.repository.RepositorySessionFactory;

public class HibernateSessonFactory extends RepositorySessionFactory {

	private SessionFactory sessionFactory = null;
	
	public HibernateSessonFactory(String config_file) {
		
		Configuration config = new Configuration();
		config.configure(new File(config_file));
		
		sessionFactory = config.buildSessionFactory();
	}


	@Override
	public RepositorySession openSession() {
		return new HibernateSession(this.sessionFactory.openSession());
	}


	@Override
	public void close() {
		this.sessionFactory.close();
	}

}
