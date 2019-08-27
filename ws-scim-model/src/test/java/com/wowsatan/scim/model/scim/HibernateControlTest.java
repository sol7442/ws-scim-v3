package com.wowsatan.scim.model.scim;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.wowsanta.scim.model.ScimUser;

public class HibernateControlTest {

	@Test
	public void test() {
		Configuration config = new Configuration();
		config.configure("wowsanta.scim.hibernate.cfg.xml");
		
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        SessionFactory sf = config.buildSessionFactory(serviceRegistry);

        
        Session session = sf.openSession();
		
		ScimUser user = new ScimUser();
		user.setId("11111");
		user.setName("kim");
		user.setActive(true);
		user.setCreateTime(new Date());
		user.setModifyTime(new Date());
		
		Transaction tr = session.beginTransaction();
		
		session.save(user);
		
		tr.commit();
		session.close();
		sf.close();
	}
}
