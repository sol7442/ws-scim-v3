package com.wowsatan.scim.model.scim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wowsanta.scim.ModelConfiguration;
import com.wowsanta.scim.model.PrimitiveJob;
import com.wowsanta.scim.model.PrimitiveOrg;
import com.wowsanta.scim.model.PrimitivePos;
import com.wowsanta.scim.model.PrimitiveUser;
import com.wowsanta.scim.model.ScimJob;
import com.wowsanta.scim.model.ScimOrg;
import com.wowsanta.scim.model.ScimPos;
import com.wowsanta.scim.model.ScimUser;

public class ModelConfigurationMake {

	@Test
	public void make() {
		
		String file_name = "../config/model.json";
		ModelConfiguration config = new ModelConfiguration();
		config.setUserPresentClass(ScimUser.class.getCanonicalName());
		config.setUserPrimitiveClass(PrimitiveUser.class.getCanonicalName());
		
		config.addGroupPrimitiveClass("org",PrimitiveOrg.class.getCanonicalName());
		config.addGroupPrimitiveClass("pos",PrimitivePos.class.getCanonicalName());
		config.addGroupPrimitiveClass("job",PrimitiveJob.class.getCanonicalName());
		
		config.addGroupPresentClass("org",ScimOrg.class.getCanonicalName());
		config.addGroupPresentClass("pos",ScimPos.class.getCanonicalName());
		config.addGroupPresentClass("job",ScimJob.class.getCanonicalName());
		
		FileWriter writer;
		try {
			writer = new FileWriter(new File(file_name));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(config,writer);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
