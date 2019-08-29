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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wowsanta.scim.HibernateProxyTypeAdapter;
import com.wowsanta.scim.model.ScimAttribute;
import com.wowsanta.scim.model.ScimGroup;
import com.wowsanta.scim.model.ScimJob;
import com.wowsanta.scim.model.ScimOrg;
import com.wowsanta.scim.model.ScimPos;
import com.wowsanta.scim.model.ScimUser;

public class HibernateControlTest {

	private static SessionFactory sessionFactory = null;

	@Before
	public void initSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("wowsanta.scim.hibernate.cfg.xml");

			sessionFactory = config.buildSessionFactory();
			System.out.println("================================open==");
		}
	}

	@After
	public void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
			System.out.println("================================close==");
		}
	}

	@Test
	public void test_load_user() {
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
			ScimUser user = session.get(ScimUser.class,"11111");
			
			tr.commit();
			session.close();
			
			Gson gson = new GsonBuilder()
					.setPrettyPrinting()
					.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();
			System.out.println("===============================1");
			System.out.println(gson.toJson(user));
			System.out.println("===============================2");
			
		} catch (Exception e) {
			System.out.println("===============================3");
			e.printStackTrace();
		}
		System.out.println("===============================4");
	}
	//@Test
	public void test_create_user_attribute() {
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();

			ScimOrg org = new ScimOrg();
			org.setId("org1");
			org.setName("orgN");
			
			ScimPos pos = new ScimPos();
			pos.setId("pos1");
			pos.setName("posN");
			
			ScimJob job = new ScimJob();
			job.setId("job1");
			job.setName("jobN");
			
			session.save(org);
			session.save(pos);
			session.save(job);
			
			
			ScimAttribute attr = new ScimAttribute(org, pos, job);
			session.save(attr);
			
			ScimUser user = new ScimUser();
			user.setId("11111");
			user.setName("kim");
			user.setActive(true);
			user.setCreateTime(new Date());
			user.setModifyTime(new Date());
			user.addAttribute(attr);

			session.save(user);

			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_create_group_user() {
//		try {
//	        Session session = sessionFactory.openSession();
//			
//			ScimGroup group = new ScimGroup();
//			Transaction tr = session.beginTransaction();
//			
//			group.setId("11111");
//			group.setName("조직도");
//			group.setOrder(1);
//			
//			session.save(group);
//			
//			ScimUser user = new ScimUser();
//			user.setId("11111");
//			user.setName("kim");
//			user.setActive(true);
//			user.setCreateTime(new Date());
//			user.setModifyTime(new Date());
//			user.addGroup(group);
//			
//			session.save(user);
//			
//			tr.commit();
//			session.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}

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
