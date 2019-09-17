package com.wowsanta.repository;


import java.util.Date;

import org.junit.Test;

import com.wowsanta.scim.model.*;
import com.wowsanta.scim.repository.RepositoryConfiguration;
import com.wowsanta.scim.repository.RepositorySession;
import com.wowsanta.scim.repository.RepositorySessionFactory;
import com.wowsanta.scim.repository.RepositoryTransaction;



public class SessionFactoryTest {

	@Test
	public void load_hibernate_config_file() {

		RepositoryConfiguration config = RepositoryConfiguration.load("../config/repository.json");
		RepositorySessionFactory repositoryFactory = config.build();
		
		
		RepositorySession session = repositoryFactory.openSession();
		RepositoryTransaction tr = session.beginTransaction();
		
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
		repositoryFactory.close();
		
	}
}
