package com.wowsanta.scim.service;

import spark.route.HttpMethod;

public class SparkRout {
	private String path;
	private HttpMethod method; 
	private String className;
	private String transClass;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTransClass() {
		return transClass;
	}
	public void setTransClass(String transClass) {
		this.transClass = transClass;
	}
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
}
