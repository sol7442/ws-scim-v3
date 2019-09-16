package com.wowsanta.scim;

import java.io.FileNotFoundException;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wowsanta.scim.service.ServiceConfiguartion;
import com.wowsanta.scim.service.SparkService;

import spark.Spark;

public class ScimProviderServer {

	static Logger logger = LoggerFactory.getLogger(ScimProviderServer.class);
	private SparkService service;
	public static void main(String[] args) {
		ScimProviderServer server = new ScimProviderServer();
		server.initialize();
		server.start();
	}

	private void start() {
		try {
			service = ServiceConfiguartion.load("../config/service.json").build();
			service.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private void stop() {
		if(service != null) {
			service.stop();
		}
	}
	
	private boolean initialize() {
		
		
		return true;
	}
	
	
}
