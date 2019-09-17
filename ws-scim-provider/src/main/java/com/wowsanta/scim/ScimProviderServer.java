package com.wowsanta.scim;

import java.io.FileNotFoundException;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wowsanta.scim.repository.RepositoryConfiguration;
import com.wowsanta.scim.repository.RepositorySessionFactory;
import com.wowsanta.scim.service.ServiceConfiguartion;
import com.wowsanta.scim.service.SparkService;

import spark.Spark;

public class ScimProviderServer {

	static Logger logger = LoggerFactory.getLogger(ScimProviderServer.class);
	private SparkService service;
	private RepositorySessionFactory repository;
	private ModelFactory model;
	
	public static void main(String[] args) {
		ScimProviderServer server = new ScimProviderServer();
		server.initialize();
		server.start();
	}

	private void start() {
		service.start();
	}
	private void stop() {
		if(service != null) {
			repository.close();
			service.stop();
		}
	}
	
	private boolean initialize() {
		try {
			model = ModelConfiguration.load("../config/model.json").build();
			repository = RepositoryConfiguration.load("../config/repository.json").build();
			service = ServiceConfiguartion.load("../config/service.json").build();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return true;
	}
	
	
}
