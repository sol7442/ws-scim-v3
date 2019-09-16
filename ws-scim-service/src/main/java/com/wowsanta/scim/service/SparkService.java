package com.wowsanta.scim.service;


import spark.Spark;
public class SparkService{
	public void start() {
		Spark.awaitInitialization();
	}
	public void stop() {
		Spark.awaitStop();
	}
}
