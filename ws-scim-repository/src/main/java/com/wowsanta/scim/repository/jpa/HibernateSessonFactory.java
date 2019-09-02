package com.wowsanta.scim.repository.jpa;

import java.io.File;
import java.util.List;

import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.cfgxml.spi.MappingReference;
import org.hibernate.cfg.Configuration;

import com.wowsanta.scim.repository.ScimSession;
import com.wowsanta.scim.repository.ScimSessionFactory;

public class HibernateSessonFactory implements ScimSessionFactory {

	private SessionFactory sessionFactory = null;

	
	public HibernateSessonFactory(String config_file) {
		
		Configuration config = new Configuration();
		config.configure(new File(config_file));
		
		sessionFactory = config.buildSessionFactory();
	}


	@Override
	public ScimSession openSession() {
		return new HibernateSession(this.sessionFactory.openSession());
	}


	@Override
	public void close() {
		this.sessionFactory.close();
	}

}
