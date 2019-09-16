package com.wowsanta.scim.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServiceConfigurationMake {

	@Test
	public void make() {
		
		String file_name = "../config/service.json";
		ServiceConfiguartion config = new ServiceConfiguartion();
				
		config.setPort(5000);
		config.setMaxThreads(10);
		
		SparkFilter filter = new SparkFilter();
		filter.setPath("/*");
		filter.setClassName("com.wowsanta.scim.service.before.AccessFilter");
		config.addBefore(filter);
		
		
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
