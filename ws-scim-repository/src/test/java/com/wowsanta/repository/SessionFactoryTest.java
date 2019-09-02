package com.wowsanta.repository;


import java.util.Date;

import org.hibernate.Transaction;
import org.junit.Test;

import com.wowsanta.scim.model.ScimAttribute;
import com.wowsanta.scim.model.ScimJob;
import com.wowsanta.scim.model.ScimOrg;
import com.wowsanta.scim.model.ScimPos;
import com.wowsanta.scim.model.ScimUser;
import com.wowsanta.scim.repository.RepositoryConfiguration;
import com.wowsanta.scim.repository.RepositoryConfiguration.REPOSITORY;
import com.wowsanta.scim.repository.ScimSession;
import com.wowsanta.scim.repository.ScimSessionFactory;
import com.wowsanta.scim.repository.ScimTransaction;



public class SessionFactoryTest {

	@Test
	public void load_hibernate_config_file() {

		RepositoryConfiguration config = RepositoryConfiguration.load("../config/repository.json");
		//config.setTyep(REPOSITORY.HIBERNATE);
		//config.save("../config/repository.json");
		
		ScimSessionFactory sessionFactory = config.build();
		
		
		ScimSession session = sessionFactory.openSession();
		ScimTransaction tr = session.beginTransaction();
		
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
		sessionFactory.close();
		
	}
}
