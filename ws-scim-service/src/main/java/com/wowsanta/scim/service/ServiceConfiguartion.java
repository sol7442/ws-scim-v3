package com.wowsanta.scim.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import spark.Filter;
import spark.ResponseTransformer;
import spark.Route;
import spark.Spark;

import static spark.Spark.*;

public class ServiceConfiguartion {

	private int port;
	private int maxThreads;
	private int minThreads;
	private int idleTimeoutMillis;
	
	private List<SparkFilter> after = new ArrayList<SparkFilter>();
	private List<SparkFilter> before = new ArrayList<SparkFilter>();
	private List<SparkRoutGroup> group = new ArrayList<SparkRoutGroup>();
	private List<SparkRout> routs  = new ArrayList<SparkRout>();
	
	public void setPort(int port) {
		this.port = port;
	}
	public int getPort() {
		return this.port;
	}
	public int getMaxThreads() {
		return maxThreads;
	}

	public void setMaxThreads(int maxThreads) {
		this.maxThreads = maxThreads;
	}

	public int getMinThreads() {
		return minThreads;
	}

	public void setMinThreads(int minThreads) {
		this.minThreads = minThreads;
	}

	public int getIdleTimeoutMillis() {
		return idleTimeoutMillis;
	}

	public void setIdleTimeoutMillis(int idleTimeoutMillis) {
		this.idleTimeoutMillis = idleTimeoutMillis;
	}

	public void addAfter(SparkFilter filter) {
		this.after.add(filter);
	}
	
	public void addBefore(SparkFilter filter) {
		this.before.add(filter);
	}
	
	public List<SparkFilter> getAfter() {
		return after;
	}

	public void setAfter(List<SparkFilter> after) {
		this.after = after;
	}

	public List<SparkFilter> getBefore() {
		return before;
	}

	public void setBefore(List<SparkFilter> before) {
		this.before = before;
	}

	public List<SparkRoutGroup> getGroup() {
		return group;
	}

	public void setGroup(List<SparkRoutGroup> group) {
		this.group = group;
	}

	public List<SparkRout> getRouts() {
		return routs;
	}

	public void setRouts(List<SparkRout> routs) {
		this.routs = routs;
	}

	public SparkService build() {
		Spark.port(this.port);
		Spark.threadPool(this.maxThreads);

		for (SparkFilter sparkFilter : after) {
			try {
				Filter filterObject = (Filter) Class.forName(sparkFilter.getClassName()).newInstance();
				after(sparkFilter.getPath(),filterObject);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
		
		for (SparkFilter sparkFilter : before) {
			try {
				Filter filterObject = (Filter) Class.forName(sparkFilter.getClassName()).newInstance();
				before(sparkFilter.getPath(),filterObject);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
		
		for (SparkRoutGroup group : this.group) {
			path(group.getPath(), ()->{
				for (SparkRout rout : group.getRouts()) {
					addRoute(rout);
				}
			} );
		}
		
		for (SparkRout rout : this.routs) {
			addRoute(rout);
		}
		
		
		return new SparkService();
	}

	private void addRoute(SparkRout rout) {
		Route method = null;
		ResponseTransformer transformer = null;
		try {
			method = (Route) Class.forName(rout.getClassName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			transformer = (ResponseTransformer) Class.forName(rout.getTransClass()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(method != null) {
			switch (rout.getMethod()) {
			case get:
				if(transformer == null)
					get(rout.getPath(),method);
				else
					get(rout.getPath(),method,transformer);
				break;
			case post:
				if(transformer == null)
					post(rout.getPath(),method);
				else
					post(rout.getPath(),method,transformer);
				break;
			case put:
				if(transformer == null)
					put(rout.getPath(),method);
				else
					put(rout.getPath(),method,transformer);
				break;
			case delete:
				if(transformer == null)
					delete(rout.getPath(),method);
				else
					delete(rout.getPath(),method,transformer);
				break;
			default:
				break;
			}	
		}
	}
	
	public static ServiceConfiguartion load(String file_name) throws FileNotFoundException {
		Gson gson = new GsonBuilder().create();
		JsonReader reader = new JsonReader(new FileReader(file_name));
		return gson.fromJson(reader,ServiceConfiguartion.class);
		
	}
}
