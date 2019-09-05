package com.wowsanta.scim;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Spark;

public class ScimProviderServer {

	static Logger logger = LoggerFactory.getLogger(ScimProviderServer.class);
	
	public static void main(String[] args) {
		ScimProviderServer server = new ScimProviderServer();
		server.initialize();
		server.start();
	}

	private void start() {
		Spark.awaitInitialization();
	}
	private void stop() {
		Spark.awaitStop();
	}
	
	private boolean initialize() {
		Spark.initExceptionHandler(new InitExceptionHandler());
		Spark.port(5000);
		Spark.threadPool(10,10,100);
		//Spark.secure
		//Spark.staticFiles.externalLocation
		//
		
		return true;
	}
	
	private class InitExceptionHandler implements Consumer<Exception> {
		@Override
		public void accept(Exception t) {
			// TODO Auto-generated method stub
		}
	}
}
