package com.wowsanta.scim.service;

import spark.ResponseTransformer;
import spark.Route;
import spark.route.HttpMethod;

public abstract class AbstractScimService implements Route {
	public abstract HttpMethod getMethod();
	public abstract String getPath();
	public abstract ResponseTransformer getTransformer();
	
}
