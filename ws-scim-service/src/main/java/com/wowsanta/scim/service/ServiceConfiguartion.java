package com.wowsanta.scim.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceConfiguartion {

	private int maxThreads;
	private int minThreads;
	private int idleTimeoutMillis;
	
	private List<SparkFilter> after = new ArrayList<SparkFilter>();
	private List<SparkFilter> before = new ArrayList<SparkFilter>();
	private List<SparkRoutGroup> group = new ArrayList<SparkRoutGroup>();
	private List<SparkRout> routs  = new ArrayList<SparkRout>();
		
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

	public boolean build() {
		
		
		
		
		
		return false;
	}
}
