package com.wowsanta.scim.service;

import java.util.ArrayList;
import java.util.List;

public class SparkRoutGroup {
	private String path;
	private List<SparkRout> routs = new ArrayList<SparkRout>();
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public void addRout(SparkRout rout) {
		this.routs.add(rout);
	}
	public List<SparkRout> getRouts() {
		return routs;
	}
	public void setRouts(List<SparkRout> routs) {
		this.routs = routs;
	}
	
}
