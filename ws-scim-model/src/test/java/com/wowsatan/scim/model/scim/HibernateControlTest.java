package com.wowsatan.scim.model.scim;


import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wowsanta.scim.model.ScimGroup;
import com.wowsanta.scim.model.ScimUser;

public class HibernateControlTest {

	private static SessionFactory sessionFactory = null;
	
	@Before
	public void initSessionFactory() {
		if(sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("wowsanta.scim.hibernate.cfg.xml");
	        
	        sessionFactory = config.buildSessionFactory();
	        System.out.println("================================open==");
		}	
	}
	
	@After
	public void closeSessionFactory(){
		if(sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
			System.out.println("================================close==");
		}		
	}
	
	@Test
	public void test_create_group_user() {
		try {
	        Session session = sessionFactory.openSession();
			
			ScimGroup group = new ScimGroup();
			Transaction tr = session.beginTransaction();
			
			group.setId("11111");
			group.setName("조직도");
			group.setOrder(1);
			
			session.save(group);
			
			ScimUser user = new ScimUser();
			user.setId("11111");
			user.setName("kim");
			user.setActive(true);
			user.setCreateTime(new Date());
			user.setModifyTime(new Date());
			user.addGroup(group);
			
			session.save(user);
			
			tr.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//	        Session session = sessionFactory.openSession();
//			
//			ScimUser user = new ScimUser();
//			user.setId("11111");
//			user.setName("kim");
//			user.setActive(true);
//			user.setCreateTime(new Date());
//			user.setModifyTime(new Date());
//			
//			Transaction tr = session.beginTransaction();
//			
//			session.save(user);
//			
//			tr.commit();
//			session.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
//	@Test
//	public void test_create_user() {
//
//	}
}
